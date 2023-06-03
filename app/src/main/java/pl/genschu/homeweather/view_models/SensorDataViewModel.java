package pl.genschu.homeweather.view_models;

import android.content.Context;
import android.database.sqlite.SQLiteException;
import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

import pl.genschu.homeweather.activities.DataViewActivity;
import pl.genschu.homeweather.objects.SensorDataObject;
import pl.genschu.homeweather.repositories.SensorDataRepository;
import pl.genschu.homeweather.sqlite.DbHelper;

public class SensorDataViewModel extends ViewModel {
    private final LiveData<List<SensorDataObject>> sensorData;

    public SensorDataViewModel(SensorDataRepository repository) {
        sensorData = repository.getAllSensorData();
    }

    public LiveData<List<SensorDataObject>> getSensorData() {
        return sensorData;
    }
}
