package pl.genschu.homeweather.adapters;

import android.os.Build;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
import java.util.Objects;

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
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.sensor_item, parent, false);
        return new SensorViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SensorViewHolder holder, int position) {
        SensorDataObject sensorData = sensorDataList.get(position);
        holder.name.setText(sensorData.getName());
        holder.idx.setText("idx: " + sensorData.getIdx());
        holder.data.setText(Html.fromHtml(formatData(sensorData.getData(), sensorData.getUnitSymbol()), Html.FROM_HTML_MODE_LEGACY));
        holder.dateUpdate.setText(sensorData.getDate());
    }

    @Override
    public int getItemCount() {
        return sensorDataList.size();
    }

    private String formatData(String[] data, String[] units) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < data.length; i++) {
            String unit = units[i];
            String value = "<b>" + data[i];
            if (!Objects.equals(unit, "null")) {
                value += " " + unit;
            }
            value += "</b>";
            if ("°C".equals(unit) || "°F".equals(unit)) {
                sb.append("Temperatura: ").append(value);
            } else if ("V".equals(unit)) {
                sb.append("Napięcie: ").append(value);
            } else if ("hPa".equals(unit)) {
                sb.append("Ciśnienie: ").append(value);
            } else {
                sb.append("Dane: ").append(value);
            }
            if(i < data.length-1) sb.append("<br>");
        }
        return sb.toString();
    }

    public static class SensorViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        TextView idx;
        TextView data;
        TextView dateUpdate;

        public SensorViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.sensor_name);
            idx = itemView.findViewById(R.id.sensor_idx);
            data = itemView.findViewById(R.id.sensor_data);
            dateUpdate = itemView.findViewById(R.id.sensor_update_time);
        }
    }

    public void updateData(List<SensorDataObject> newSensorDataList) {
        this.sensorDataList.clear();
        this.sensorDataList.addAll(newSensorDataList);
        notifyDataSetChanged(); //wiem, może to zmienię
    }
}
