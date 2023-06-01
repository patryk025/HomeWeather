package pl.genschu.homeweather.activities;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

@SuppressLint("CustomSplashScreen")
public class SplashScreenActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SharedPreferences sharedPreferences = getSharedPreferences("MyApp", MODE_PRIVATE);
        String domoticzUrl = sharedPreferences.getString("domoticzUrl", "");
        String homeAssistantUrl = sharedPreferences.getString("homeAssistantUrl", "");
        /*if(domoticzUrl.isEmpty() && homeAssistantUrl.isEmpty()){
            startActivity(new Intent(this, SettingsActivity.class));
        }
        else {*/
            startActivity(new Intent(this, DataViewActivity.class));
        //}
        finish();
    }
}
