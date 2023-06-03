package pl.genschu.homeweather.repositories;

import androidx.lifecycle.LiveData;

import java.util.List;

import pl.genschu.homeweather.objects.SensorDataObject;

public interface SensorDataRepository {
    LiveData<List<SensorDataObject>> getAllSensorData();
}
