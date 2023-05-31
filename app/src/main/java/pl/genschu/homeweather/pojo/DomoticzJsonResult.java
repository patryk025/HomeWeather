package pl.genschu.homeweather.pojo; 
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

public class DomoticzJsonResult {
    @JsonProperty("AddjMulti") 
    public double addjMulti;
    @JsonProperty("AddjMulti2") 
    public double addjMulti2;
    @JsonProperty("AddjValue") 
    public double addjValue;
    @JsonProperty("AddjValue2") 
    public double addjValue2;
    @JsonProperty("Barometer") 
    public double barometer;
    @JsonProperty("BatteryLevel") 
    public int batteryLevel;
    @JsonProperty("CustomImage") 
    public int customImage;
    @JsonProperty("Data") 
    public String data;
    @JsonProperty("Description") 
    public String description;
    @JsonProperty("Favorite") 
    public int favorite;
    @JsonProperty("Forecast") 
    public int forecast;
    @JsonProperty("ForecastStr") 
    public String forecastStr;
    @JsonProperty("HardwareDisabled") 
    public boolean hardwareDisabled;
    @JsonProperty("HardwareID") 
    public int hardwareID;
    @JsonProperty("HardwareName") 
    public String hardwareName;
    @JsonProperty("HardwareType") 
    public String hardwareType;
    @JsonProperty("HardwareTypeVal") 
    public int hardwareTypeVal;
    @JsonProperty("HaveTimeout") 
    public boolean haveTimeout;
    @JsonProperty("ID") 
    public String iD;
    @JsonProperty("LastUpdate") 
    public String lastUpdate;
    @JsonProperty("Name") 
    public String name;
    @JsonProperty("Notifications") 
    public String notifications;
    @JsonProperty("PlanID") 
    public String planID;
    @JsonProperty("PlanIDs") 
    public ArrayList<Integer> planIDs;
    @JsonProperty("Protected")
    public boolean protected_;
    @JsonProperty("ShowNotifications") 
    public boolean showNotifications;
    @JsonProperty("SignalLevel") 
    public String signalLevel;
    @JsonProperty("SubType") 
    public String subType;
    @JsonProperty("Temp") 
    public double temp;
    @JsonProperty("Timers") 
    public String timers;
    @JsonProperty("Type") 
    public String type;
    @JsonProperty("TypeImg") 
    public String typeImg;
    @JsonProperty("Unit") 
    public int unit;
    @JsonProperty("Used") 
    public int used;
    @JsonProperty("XOffset") 
    public String xOffset;
    @JsonProperty("YOffset") 
    public String yOffset;
    public String idx;
    public int trend;
    @JsonProperty("Voltage") 
    public double voltage;
    @JsonProperty("DewPoint") 
    public String dewPoint;
    @JsonProperty("Humidity") 
    public int humidity;
    @JsonProperty("HumidityStatus") 
    public String humidityStatus;
}
