package pl.genschu.homeweather.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import pl.genschu.homeweather.objects.SensorDataObject;

public class DbHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "HomeWeather";
    private static final int DB_VERSION = 1;

    DbHelper(Context context) {
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

    private static void insertData(SQLiteDatabase db, SensorDataObject object) {
        ContentValues obiektValues = new ContentValues();
        obiektValues.put("id", object.getIdx());
        obiektValues.put("data", object.getData());
        obiektValues.put("unit", object.getUnitSymbol());
        db.insert(object.getEngine(), null, obiektValues);
    }

    private void updateMyDatabase(SQLiteDatabase db, int oldVersion, int newVersion) {
        /*if(oldVersion < 1) {
            db.execSQL("CREATE TABLE ORGANIZACJA (_id INTEGER PRIMARY KEY AUTOINCREMENT, NAZWA TEXT, RODZAJ TEXT);");
            wstawOrganizacja(db, "Koło Naukowe Informatyki", "koło naukowe");
            wstawOrganizacja(db, "Akademicki Zespół Sportowy", "sport");
            wstawOrganizacja(db, "Bulionik", "akademik");
            wstawOrganizacja(db, "Katedra Informatyki", "katedra");
            wstawOrganizacja(db, "Sieć Uczelniana", "administrator");
        }
        if(oldVersion < 2) {
            db.execSQL("ALTER TABLE ORGANIZACJA ADD COLUMN TELEFON TEXT;");
        }*/
    }
}