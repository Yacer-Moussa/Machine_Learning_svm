package data.save;

import android.app.Application;
import android.content.Context;

import androidx.room.Room;

import com.screenrate.app.Empfehlungen;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import data.AppDatabase;
import data.model.Anbieter;
import data.model.Benutzer;
import data.model.Bewertung;
import data.model.Empfehlung;
import data.model.Kategorie;
import data.model.Screen;


public class status extends Application {

    private long MyUserID;


    private String MyUserName;

    private AppDatabase appDatabase;
    private List<Benutzer> benutzerList;
    private List<Screen> screenList;

    public List<Benutzer> getBenutzerList() {
        return benutzerList;
    }

    public List<Screen> getScreenList() {
        return screenList;
    }

    public List<Anbieter> getAnbieterList() {
        return anbieterList;
    }

    public List<Kategorie> getKategorieList() {
        return kategorieList;
    }

    public List<Bewertung> getBewertungList() {
        return bewertungList;
    }

    public List<Empfehlung> getEmpfehlungList() {
        return empfehlungList;
    }
    public void addScreen(Screen screen){
        screenList.add(screen);
    }
    public void addEmpfehlung(Empfehlung empfehlung){
        empfehlungList.add(empfehlung);
    }
    public void addBewertung(Bewertung bewertung){
        bewertungList.add(bewertung);
    }
    public void addKategorie(Kategorie kategorie){
        kategorieList.add(kategorie);
    }
    public void addAnbieter(Anbieter anbieter){
        anbieterList.add(anbieter);
    }
    public void addBenutzer(Benutzer benutzer){
        benutzerList.add(benutzer);
    }
    private List<Anbieter> anbieterList;
    private List<Kategorie> kategorieList;
    private List<Bewertung> bewertungList;
    private List<Empfehlung> empfehlungList;

    public void loadNew(Context context){
        appDatabase = AppDatabase.getInstance(context);
        this.load(context);
        //Imput data into DB manually
        /*
        Kategorie kategorie = new Kategorie("Western");
        appDatabase.kategorieAccessObject().KategorieRegistrieren(kategorie);
         */
    }
    public boolean load(Context context){
        benutzerList = appDatabase.benutzerAccessObject().getAll();
        screenList = appDatabase.screenAccessObject().getAll();
        anbieterList = appDatabase.anbieterAccessObject().getAll();
        kategorieList = appDatabase.kategorieAccessObject().getAll();
        bewertungList = appDatabase.bewertungAccessObject().getAll();
        empfehlungList = appDatabase.empfehlungAccessObject().getAll();
        return true;
    }

    public boolean save(){
        appDatabase.benutzerAccessObject().BenutzerUpdate(benutzerList);
        appDatabase.anbieterAccessObject().AnbieterUpdate(anbieterList);
        appDatabase.screenAccessObject().ScreenUpdate(screenList);
        appDatabase.kategorieAccessObject().KategorieUpdate(kategorieList);
        appDatabase.bewertungAccessObject().BewertungUpdate(bewertungList);
        appDatabase.empfehlungAccessObject().EmpfehlungUpdate(empfehlungList);
        return true;
    }

    public long getMyUserID() {
        return MyUserID;
    }

    public void setMyUserID(long MyUserID) {
        this.MyUserID = MyUserID;
    }
    public String getMyUserName() {return MyUserName;}
    public void setMyUserName(String myUserName) {MyUserName = myUserName;}

    public Long getUserIDbyName(String name) throws UserNotFoundExeption{
        Benutzer endBenutzer = benutzerList.stream().filter(benutzer -> name.equals(benutzer.Anzeigename)).findAny().orElse(null);
        if(endBenutzer == null){
            endBenutzer = benutzerList.stream().filter(benutzer -> name.equals(benutzer.Email)).findAny().orElse(null);
        }
        if(endBenutzer == null){
            throw new UserNotFoundExeption();
        }
        return endBenutzer.BenutzerID;
    }
    public String getUserNamebyID(long id){
        return benutzerList.stream().filter((benutzer) -> benutzer.BenutzerID == id).findFirst().get().Anzeigename;
    }
    public boolean validatePassword(long BenutzerID, String Password) {
        Benutzer benutzer = benutzerList.stream().filter(benutzer1 -> BenutzerID == benutzer1.BenutzerID).findAny().orElse(null);
        if(Password.equals(benutzer.Password))
        {
            return true;
        }
        return false;
    }

    public int getScreenCount(){
        return screenList.size();
    }

    public String getScreenName(long screenID){
        //Error
        Screen screen = screenList.get((int)screenID);
        return screen.getName();
    }


    private boolean filter(){
        //if(id.getScreenID() == screenID){return true}
        //else {return false};
        return false;
    }

    public int getEmpfehlungenCount() {
        return empfehlungList.size();
    }

    public boolean dbPopulated(){
        if(appDatabase.anbieterAccessObject().getAll().size() >= 17){
            return true;
        }
        return false;
    }
}
