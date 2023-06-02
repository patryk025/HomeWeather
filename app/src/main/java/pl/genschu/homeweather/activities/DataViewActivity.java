package pl.genschu.homeweather.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;

import java.util.List;

import pl.genschu.homeweather.R;
import pl.genschu.homeweather.objects.SensorDataObject;
import pl.genschu.homeweather.services.DomoticzDataService;
import pl.genschu.homeweather.view_models.SensorDataViewModel;

public class DataViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_view);

        startService(new Intent(getBaseContext(), DomoticzDataService.class));

        SensorDataViewModel viewModel = new ViewModelProvider(this).get(SensorDataViewModel.class);

        // Observe the LiveData.
        viewModel.getSensorData().observe(this, this::updateUI);

        // Register the broadcast receiver.
        registerReceiver(new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                if ("ACTION_REFRESH".equals(intent.getAction())) {
                    // Refresh the UI.
                    updateUI(viewModel.getSensorData().getValue());
                }
            }
        }, new IntentFilter("ACTION_REFRESH"));
    }

    private void updateUI(List<SensorDataObject> data) {
        // Update your UI here.
    }
}