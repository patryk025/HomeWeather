package pl.genschu.homeweather.apis;

import java.util.List;

import pl.genschu.homeweather.pojo.sensors.DomoticzJsonRoot;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface DomoticzAPI {
    @GET("/json.htm?type=devices&used=true&order=Name")
    Call<List<DomoticzJsonRoot>> getSensors();

    //@GET("/json.htm?type=graph&sensor={type}&idx={idx}&range=day")
    //Call<List<SensorDataObject>> getHistory(@Path("type") String type, @Path("idx") String idx);
}
