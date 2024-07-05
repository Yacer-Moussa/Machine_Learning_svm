package data;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.AutoMigration;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.screenrate.app.Empfehlungen;

import java.io.File;

import data.access.AnbieterAccessObject;
import data.access.BenutzerAccessObject;
import data.access.BewertungAccessObject;
import data.access.EmpfehlungAccessObject;
import data.access.KategorieAccessObject;
import data.access.ScreenAccessObject;
import data.model.Anbieter;
import data.model.Benutzer;
import data.model.Bewertung;
import data.model.Empfehlung;
import data.model.Kategorie;
import data.model.Screen;

@Database(entities = {Anbieter.class, Benutzer.class, Bewertung.class, Kategorie.class, Screen.class, Empfehlung.class}, version = 3)
public abstract class AppDatabase extends RoomDatabase {

    private static final String DB_NAME = "AppDatabase";
    private static volatile AppDatabase INSTANCE;
    public static synchronized AppDatabase getInstance(Context context){
        if(INSTANCE == null)
        {
            synchronized (AppDatabase.class) {
            if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),AppDatabase.class, DB_NAME).fallbackToDestructiveMigration().allowMainThreadQueries().build();
                }
            }
        }
        return INSTANCE;
    }

    public abstract AnbieterAccessObject anbieterAccessObject();
    public abstract BenutzerAccessObject benutzerAccessObject();
    public abstract BewertungAccessObject bewertungAccessObject();
    public abstract KategorieAccessObject kategorieAccessObject();
    public abstract ScreenAccessObject screenAccessObject();
    public abstract EmpfehlungAccessObject empfehlungAccessObject();

}

