package pl.genschu.homeweather.repositories;

import android.content.Context;
import android.database.sqlite.SQLiteException;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.List;

import pl.genschu.homeweather.objects.SensorDataObject;
import pl.genschu.homeweather.sqlite.DbHelper;

public class SensorDataRepositoryClient implements SensorDataRepository {
    private final DbHelper dbHelper;

    public SensorDataRepositoryClient(Context context) {
        dbHelper = new DbHelper(context);
    }

    @Override
    public LiveData<List<SensorDataObject>> getAllSensorData() {
        MutableLiveData<List<SensorDataObject>> data = new MutableLiveData<>();
        try {
            data.setValue(dbHelper.getAllSensorData());
        } catch (SQLiteException e) {
            // Handle exception
        }
        return data;
    }
}
