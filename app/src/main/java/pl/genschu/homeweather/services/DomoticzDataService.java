package pl.genschu.homeweather.services;

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.Intent;
import android.util.Log;

import java.io.IOException;
import java.util.List;

import pl.genschu.homeweather.apis.DomoticzAPI;
import pl.genschu.homeweather.helpers.RetrofitClient;
import pl.genschu.homeweather.objects.SensorDataObject;
import pl.genschu.homeweather.pojo.sensors.DomoticzJsonResult;
import pl.genschu.homeweather.pojo.sensors.DomoticzJsonRoot;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DomoticzDataService extends JobService {
    @Override
    public boolean onStartJob(JobParameters params) {
        Log.d("HomeWeather", "Domoticz Service started...");
        DomoticzAPI service = new RetrofitClient("192.168.2.249", "8080", "admin", "Wiedzmin3DzikiGon_!").getClient().create(DomoticzAPI.class);

        service.getSensors().enqueue(new Callback<DomoticzJsonRoot>() {
            @Override
            public void onResponse(Call<DomoticzJsonRoot> call, Response<DomoticzJsonRoot> response) {
                if (response.isSuccessful()) {
                    Log.d("DomoticzAPI", "response success");
                    DomoticzJsonRoot sensors = response.body();
                    saveDataToDatabase(sensors);

                    Intent intent = new Intent("ACTION_REFRESH");
                    sendBroadcast(intent);
                } else {
                    Log.e("DomoticzAPI", "response failed");
                }
            }

            @Override
            public void onFailure(Call<DomoticzJsonRoot> call, Throwable t) {
                Log.e("DomoticzAPI", "response error");
                Log.e("DomoticzAPI", String.valueOf(t));
            }
        });

        return false;
    }

    @Override
    public boolean onStopJob(JobParameters params) {
        return false;
    }

    private void saveDataToDatabase(DomoticzJsonRoot response) {
        List<DomoticzJsonResult> sensorsRawData = response.getResult();
        SensorDataObject tmp;
        for(DomoticzJsonResult sensorRawData : sensorsRawData) {
            tmp = new SensorDataObject(Integer.parseInt(sensorRawData.getIdx()), sensorRawData.getName(), "temp", sensorRawData.getData(), ""+sensorRawData.getUnit(), sensorRawData.getLastUpdate());
        }
        Log.d("Test", "saveDataToDatabase");
    }


}
