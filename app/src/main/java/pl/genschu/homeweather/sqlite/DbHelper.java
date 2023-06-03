package pl.genschu.homeweather.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import pl.genschu.homeweather.builders.SensorDataBuilder;
import pl.genschu.homeweather.objects.SensorDataObject;

public class DbHelper extends SQLiteOpenHelper {
    private static final String DB_NAME = "HomeWeather";
    private static final int DB_VERSION = 1;

    public DbHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        updateMyDatabase(db, 0, DB_VERSION);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        updateMyDatabase(db, oldVersion, newVersion);
    }

    public void insertData(SensorDataObject object) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.beginTransaction();
        try {
            String sql = "INSERT OR REPLACE INTO SENSOR_DATA (idx, name, data, unit, engine, date) VALUES (?, ?, ?, ?, ?, ?)";
            db.execSQL(sql, new Object[]{object.getIdx(), object.getName(), String.join("|", object.getData()), String.join("|", object.getUnitSymbol()), object.getEngine(), object.getDate()});
            db.setTransactionSuccessful();
        } catch (Exception e) {
            // handle error
        } finally {
            db.endTransaction();
        }
    }

    private void updateMyDatabase(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (oldVersion < 1) {
            db.execSQL("CREATE TABLE SENSOR_DATA ("
                    + "_id INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + "idx INTEGER UNIQUE, "
                    + "name TEXT, "
                    + "data TEXT, "
                    + "engine TEXT, "
                    + "unit TEXT, "
                    + "date TEXT);");
        }
    }

    public List<SensorDataObject> getAllSensorData() {
        List<SensorDataObject> sensorDataList = new ArrayList<>();

        // select all query
        String selectQuery = "SELECT * FROM SENSOR_DATA";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                SensorDataObject sensorData = new SensorDataBuilder()
                        .addIdx(cursor.getInt(cursor.getColumnIndexOrThrow("idx")))
                        .addName(cursor.getString(cursor.getColumnIndexOrThrow("name")))
                        .addEngine(cursor.getString(cursor.getColumnIndexOrThrow("engine")))
                        .addData(cursor.getString(cursor.getColumnIndexOrThrow("data")).split("\\|"))
                        .addUnitSymbol(cursor.getString(cursor.getColumnIndexOrThrow("unit")).split("\\|"))
                        .addDate(cursor.getString(cursor.getColumnIndexOrThrow("date")))
                        .build();

                // adding to list
                sensorDataList.add(sensorData);
            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();

        return sensorDataList;
    }
}