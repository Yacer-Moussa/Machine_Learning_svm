package data.access;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import data.model.Benutzer;

@Dao
public interface BenutzerAccessObject {
    @Insert(onConflict = OnConflictStrategy.ROLLBACK)
    void BenutzerRegistrieren(Benutzer... benutzer);
    @Update
    void BenutzerUpdate(List<Benutzer> benutzer);
    @Query("SELECT BenutzerID FROM Benutzer WHERE Anzeigename IS (:name)")
    Long getUserIDByName(String name);
    @Query("SELECT BenutzerID FROM Benutzer WHERE Email IS (:email)")
    Long getUserIDByEmail(String email);

    @Query("SELECT * FROM Benutzer WHERE BenutzerID IS (:benutzerID)")
    Benutzer getUser(long benutzerID);

    @Query("SELECT * FROM Benutzer")
    List<Benutzer> getAll();

    @Query("SELECT Anzeigename FROM Benutzer WHERE BenutzerID IS (:id)")
    String getUserNameByID(long id);

}
