package data.model;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Screen")
public class Screen {

    @PrimaryKey(autoGenerate = true) @NonNull
    public long ScreenID;

    @NonNull
    public static long zcreenID;
    @NonNull
    public String Name;
    @ColumnInfo(name = "Beschreibung") @NonNull
    public String Beschreibung;

    public Screen(long ScreenID, String name, String beschreibung) {
        this.ScreenID = ScreenID;
        Name = name;
        Beschreibung = beschreibung;
        zcreenID = ScreenID;
    }

    public static boolean isScreen(long screenID){
        if (screenID == zcreenID){
            return true;
        }
        else {
            return false;
        }
    }

    public Screen() {
        zcreenID = ScreenID;
    }

    @Override
    public String toString() {
        return "Screen{" +
                "ScreenID=" + ScreenID +
                ", Name='" + Name + '\'' +
                ", Beschreibung='" + Beschreibung + '\'' +
                '}';
    }

    public long getScreenID() {
        return ScreenID;
    }

    @NonNull
    public String getName() {
        return Name;
    }

    public void setName(@NonNull String name) {
        Name = name;
    }

    @NonNull
    public String getBeschreibung() {
        return Beschreibung;
    }

    public void setBeschreibung(@NonNull String beschreibung) {
        Beschreibung = beschreibung;
    }

    //@ColumnInfo(name = "Bewertungen")
    //@ColumnInfo(name = "Genres")
    //@ColumnInfo(name = "Streamiganbieter")
}
