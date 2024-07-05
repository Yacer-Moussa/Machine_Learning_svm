package data.model;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Bewertung",primaryKeys = {"AutorID","ScreenID"})
public class Bewertung {

    public Bewertung() {
    }

    public long getAutorID() {
        return AutorID;
    }

    public long getScreenID() {
        return ScreenID;
    }

    @NonNull
    public String getBewertung() {
        return Bewertung;
    }

    public void setBewertung(@NonNull String bewertung) {
        Bewertung = bewertung;
    }

    public void setAutorID(long autorID) {
        AutorID = autorID;
    }

    public void setScreenID(long screenID) {
        ScreenID = screenID;
    }

    @NonNull
    private long AutorID;
    @NonNull
    private long ScreenID;

    @NonNull
    private String Bewertung;

    public Bewertung(long autorID, long screenID, String bewertung){
        AutorID = autorID;
        ScreenID = screenID;
        Bewertung = bewertung;
    }

    @Override
    public String toString() {
        return "Bewertung{" +
                "AutorID=" + AutorID +
                ", ScreenID=" + ScreenID +
                ", Bewertung='" + Bewertung + '\'' +
                '}';
    }
}
