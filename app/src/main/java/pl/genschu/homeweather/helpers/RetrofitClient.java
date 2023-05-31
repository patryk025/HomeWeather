package pl.genschu.homeweather.helpers;

import android.util.Base64;

import androidx.annotation.NonNull;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    private String serverName;
    private String port;
    private String login;
    private String password;

    //TODO: ładowanie konfigów z ustawień
    public RetrofitClient(String serverName, String port, String login, String password) {
        this.serverName = serverName;
        this.port = port;
        this.login = login;
        this.password = password;
    }

    public Retrofit getClient() {
        OkHttpClient client = new OkHttpClient.Builder()
            .addInterceptor(chain -> {
                Request originalRequest = chain.request();

                Request newRequest = originalRequest.newBuilder()
                        .header("Authorization", getBasicAuthHeader(RetrofitClient.this.login, RetrofitClient.this.password))
                        .build();

                return chain.proceed(newRequest);
            })
            .build();

        return new Retrofit.Builder()
                .baseUrl("http://"+ this.serverName+":"+ this.port)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    private static String getBasicAuthHeader(String username, String password) {
        String credentials = username + ":" + password;
        return "Basic " + Base64.encodeToString(credentials.getBytes(), Base64.NO_WRAP);
    }
}
