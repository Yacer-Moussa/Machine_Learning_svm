package data.model;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

@Entity(tableName = "Benutzer")
public class Benutzer {

    public Benutzer(String anzeigename, String email, String password, Date geburtsdatum) {
        Anzeigename = anzeigename;
        Email = email;
        Password = password;
        Geburtsdatum = geburtsdatum.toString();
    }
    @PrimaryKey(autoGenerate = true) @NonNull
    public long BenutzerID;
    @ColumnInfo(name = "Anzeigename") @NonNull
    public String Anzeigename;
    @ColumnInfo(name = "Email") @NonNull
    public String Email;
    @ColumnInfo(name = "Password") @NonNull
    public String Password;
    @ColumnInfo(name = "Geburtsdatum") @NonNull
    public String Geburtsdatum;
    //@ColumnInfo(name = "Gemerkte Screens")
    //public ArrayList<String> gemerkteScreens;
    //@ColumnInfo(name = "Meine Anbieter")
    //public ArrayList<String> meineAnbieter;
    //@ColumnInfo(name = "Meine Kategorien")
    //public ArrayList<String> meineKategorien;
    //@ColumnInfo(name = "Freundesliste")
    //public ArrayList<Long> FreundeslisteIDs;

    @Override
    public String toString() {
        return "Benutzer{" +
                "BenutzerID=" + BenutzerID +
                ", Anzeigename='" + Anzeigename + '\'' +
                ", Email='" + Email + '\'' +
                ", Password='" + Password + '\'' +
                ", Geburtsdatum='" + Geburtsdatum + '\'' +
                '}';
    }

    public Benutzer() {
    }



    //@ColumnInfo(name = "Streaminganbieter")
    //@ColumnInfo(name = "Kategorien")
    //@ColumnInfo(name = "GemerkteListe")
    //@ColumnInfo(name = "Empfehlungen")
    //@ColumnInfo(name = "Freunde")
    //@ColumnInfo(name = "MeineBewertungen")
}
