package pl.genschu.homeweather.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import pl.genschu.homeweather.R;
import pl.genschu.homeweather.objects.SensorDataObject;

public class SensorAdapter extends RecyclerView.Adapter<SensorAdapter.SensorViewHolder> {
    private List<SensorDataObject> sensorDataList;

    public SensorAdapter(List<SensorDataObject> sensorDataList) {
        this.sensorDataList = sensorDataList;
    }

    @NonNull
    @Override
    public SensorViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Here you inflate the layout of a single item
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.sensor_item, parent, false);
        return new SensorViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SensorViewHolder holder, int position) {
        // Here you bind the data to the views
        SensorDataObject sensorData = sensorDataList.get(position);
        holder.name.setText(sensorData.getName());
        // Set other fields as necessary
    }

    @Override
    public int getItemCount() {
        return sensorDataList.size();
    }

    public static class SensorViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        // Declare other views as necessary

        public SensorViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.sensor_name);
            // Initialize other views
        }
    }
}
