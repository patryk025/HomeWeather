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
import pl.genschu.homeweather.pojo.sensors.DomoticzJsonRoot;
import retrofit2.Response;

public class DomoticzDataService extends JobService {
    @Override
    public boolean onStartJob(JobParameters params) {
        DomoticzAPI service = new RetrofitClient("192.168.2.249", "8080", "admin", "Wiedzmin3DzikiGon_!").getClient().create(DomoticzAPI.class);
        Response<List<DomoticzJsonRoot>> response = null;
        try {
            response = service.getSensors().execute();
            List<DomoticzJsonRoot> sensors = response.body();

            saveDataToDatabase(sensors);

            Intent intent = new Intent("ACTION_REFRESH");
            sendBroadcast(intent);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return false;
    }

    @Override
    public boolean onStopJob(JobParameters params) {
        return false;
    }

    private void saveDataToDatabase(List<DomoticzJsonRoot> response) {
        Log.d("Test", "saveDataToDatabase");
    }
}
