package pl.genschu.homeweather.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import java.util.List;

import pl.genschu.homeweather.R;
import pl.genschu.homeweather.adapters.SensorAdapter;
import pl.genschu.homeweather.objects.SensorDataObject;
import pl.genschu.homeweather.repositories.SensorDataRepository;
import pl.genschu.homeweather.repositories.SensorDataRepositoryClient;
import pl.genschu.homeweather.services.DomoticzDataService;
import pl.genschu.homeweather.view_models.SensorDataViewModel;

public class DataViewActivity extends AppCompatActivity {
    private int jobId = 0;
    private SensorAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_view);

        SensorDataRepository repository = new SensorDataRepositoryClient(this);
        SensorDataViewModel viewModel = new SensorDataViewModel(repository);

        startService();

        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new SensorAdapter(viewModel.getSensorData().getValue());
        recyclerView.setAdapter(adapter);

        // Observe the LiveData.
        viewModel.getSensorData().observe(this, this::updateUI);

        // Register the broadcast receiver.
        registerReceiver(new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                Log.d("DataViewActivity", "received "+intent.getAction());
                if ("ACTION_REFRESH".equals(intent.getAction())) {
                    // Refresh the UI.
                    updateUI(viewModel.getSensorData().getValue());
                }
            }
        }, new IntentFilter("ACTION_REFRESH"));
    }

    private void startService() {
        JobScheduler jobScheduler = (JobScheduler) getSystemService(Context.JOB_SCHEDULER_SERVICE);
        JobInfo jobInfo = new JobInfo.Builder(jobId++, new ComponentName(this, DomoticzDataService.class))
                // set any constraints here
                .setRequiredNetworkType(JobInfo.NETWORK_TYPE_ANY)
                .setPersisted(true)
                .build();
        jobScheduler.schedule(jobInfo);
    }

    private void updateUI(List<SensorDataObject> data) {
        Log.d("DataViewActivity", "updateData");
        adapter.updateData(data);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.action_refresh) {
            startService();
        }
        else if(item.getItemId() == R.id.action_settings) {
            Intent intent = new Intent(getApplicationContext(), SettingsActivity.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }
}