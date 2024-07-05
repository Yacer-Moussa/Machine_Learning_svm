package data.model;

import androidx.annotation.NonNull;
import androidx.room.Entity;

@Entity(tableName = "Empfehlung", primaryKeys = {"empfohlenVon", "screenName"})
public class Empfehlung{
    @NonNull
    private String empfohlenVon;
    @NonNull
    private String kommentar;
    @NonNull
    private String screenName;

    public Empfehlung(String empfohlenVon, String kommentar, String screenName) {
        this.empfohlenVon = empfohlenVon;
        this.kommentar = kommentar;
        this.screenName = screenName;
    }

    public Empfehlung() {
    }

    @NonNull
    public String getEmpfohlenVon() {
        return empfohlenVon;
    }

    public void setEmpfohlenVon(@NonNull String empfohlenVon) {
        this.empfohlenVon = empfohlenVon;
    }

    @NonNull
    public String getKommentar() {
        return kommentar;
    }

    public void setKommentar(@NonNull String kommentar) {
        this.kommentar = kommentar;
    }

    @NonNull
    public String getScreenName() {
        return screenName;
    }

    public void setScreenName(@NonNull String screenName) {
        this.screenName = screenName;
    }
}

