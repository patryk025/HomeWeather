
package pl.genschu.homeweather.pojo.sensors;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DomoticzJsonRoot {

    @SerializedName("ActTime")
    @Expose
    private Integer actTime;
    @SerializedName("AstrTwilightEnd")
    @Expose
    private String astrTwilightEnd;
    @SerializedName("AstrTwilightStart")
    @Expose
    private String astrTwilightStart;
    @SerializedName("CivTwilightEnd")
    @Expose
    private String civTwilightEnd;
    @SerializedName("CivTwilightStart")
    @Expose
    private String civTwilightStart;
    @SerializedName("DayLength")
    @Expose
    private String dayLength;
    @SerializedName("NautTwilightEnd")
    @Expose
    private String nautTwilightEnd;
    @SerializedName("NautTwilightStart")
    @Expose
    private String nautTwilightStart;
    @SerializedName("ServerTime")
    @Expose
    private String serverTime;
    @SerializedName("SunAtSouth")
    @Expose
    private String sunAtSouth;
    @SerializedName("Sunrise")
    @Expose
    private String sunrise;
    @SerializedName("Sunset")
    @Expose
    private String sunset;
    @SerializedName("app_version")
    @Expose
    private String appVersion;
    @SerializedName("result")
    @Expose
    private List<DomoticzJsonResult> domoticzJsonResult;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("title")
    @Expose
    private String title;

    public Integer getActTime() {
        return actTime;
    }

    public void setActTime(Integer actTime) {
        this.actTime = actTime;
    }

    public String getAstrTwilightEnd() {
        return astrTwilightEnd;
    }

    public void setAstrTwilightEnd(String astrTwilightEnd) {
        this.astrTwilightEnd = astrTwilightEnd;
    }

    public String getAstrTwilightStart() {
        return astrTwilightStart;
    }

    public void setAstrTwilightStart(String astrTwilightStart) {
        this.astrTwilightStart = astrTwilightStart;
    }

    public String getCivTwilightEnd() {
        return civTwilightEnd;
    }

    public void setCivTwilightEnd(String civTwilightEnd) {
        this.civTwilightEnd = civTwilightEnd;
    }

    public String getCivTwilightStart() {
        return civTwilightStart;
    }

    public void setCivTwilightStart(String civTwilightStart) {
        this.civTwilightStart = civTwilightStart;
    }

    public String getDayLength() {
        return dayLength;
    }

    public void setDayLength(String dayLength) {
        this.dayLength = dayLength;
    }

    public String getNautTwilightEnd() {
        return nautTwilightEnd;
    }

    public void setNautTwilightEnd(String nautTwilightEnd) {
        this.nautTwilightEnd = nautTwilightEnd;
    }

    public String getNautTwilightStart() {
        return nautTwilightStart;
    }

    public void setNautTwilightStart(String nautTwilightStart) {
        this.nautTwilightStart = nautTwilightStart;
    }

    public String getServerTime() {
        return serverTime;
    }

    public void setServerTime(String serverTime) {
        this.serverTime = serverTime;
    }

    public String getSunAtSouth() {
        return sunAtSouth;
    }

    public void setSunAtSouth(String sunAtSouth) {
        this.sunAtSouth = sunAtSouth;
    }

    public String getSunrise() {
        return sunrise;
    }

    public void setSunrise(String sunrise) {
        this.sunrise = sunrise;
    }

    public String getSunset() {
        return sunset;
    }

    public void setSunset(String sunset) {
        this.sunset = sunset;
    }

    public String getAppVersion() {
        return appVersion;
    }

    public void setAppVersion(String appVersion) {
        this.appVersion = appVersion;
    }

    public List<DomoticzJsonResult> getResult() {
        return domoticzJsonResult;
    }

    public void setResult(List<DomoticzJsonResult> domoticzJsonResult) {
        this.domoticzJsonResult = domoticzJsonResult;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}
