package pl.genschu.homeweather.view_models;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

import pl.genschu.homeweather.objects.SensorDataObject;

public class SensorDataViewModel extends ViewModel {
    // LiveData object for sensor data.
    private final LiveData<List<SensorDataObject>> sensorData;

    public SensorDataViewModel() {
        sensorData = loadSensorDataFromDatabase();
    }

    public LiveData<List<SensorDataObject>> getSensorData() {
        return sensorData;
    }

    private LiveData<List<SensorDataObject>> loadSensorDataFromDatabase() {
        Log.d("Test", "loadSensorDataFromDatabase");
        return null;
    }
}