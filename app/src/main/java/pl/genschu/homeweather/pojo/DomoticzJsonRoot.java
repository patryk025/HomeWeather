package pl.genschu.homeweather.pojo; 
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

public class DomoticzJsonRoot {
    @JsonProperty("ActTime")
    public int actTime;
    @JsonProperty("AstrTwilightEnd") 
    public String astrTwilightEnd;
    @JsonProperty("AstrTwilightStart") 
    public String astrTwilightStart;
    @JsonProperty("CivTwilightEnd") 
    public String civTwilightEnd;
    @JsonProperty("CivTwilightStart") 
    public String civTwilightStart;
    @JsonProperty("DayLength") 
    public String dayLength;
    @JsonProperty("NautTwilightEnd") 
    public String nautTwilightEnd;
    @JsonProperty("NautTwilightStart") 
    public String nautTwilightStart;
    @JsonProperty("ServerTime") 
    public String serverTime;
    @JsonProperty("SunAtSouth") 
    public String sunAtSouth;
    @JsonProperty("Sunrise") 
    public String sunrise;
    @JsonProperty("Sunset") 
    public String sunset;
    public String app_version;
    public ArrayList<DomoticzJsonResult> result;
    public String status;
    public String title;
}
