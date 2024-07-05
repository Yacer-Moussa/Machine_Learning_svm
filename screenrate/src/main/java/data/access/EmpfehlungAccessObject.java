package data.access;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.ArrayList;
import java.util.List;

import data.model.Bewertung;
import data.model.Empfehlung;

@Dao
public interface EmpfehlungAccessObject {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void EmpfehlungSchreiben(Empfehlung... empfehlung);
    @Update
    void EmpfehlungUpdate(List<Empfehlung> empfehlungen);
    @Query("SELECT * FROM Empfehlung")
    List<Empfehlung> getAll();
    @Query("SELECT * FROM Empfehlung WHERE screenName = :name")
    List<Empfehlung> getForUser(String name);
    @Query("SELECT COUNT(*) FROM Empfehlung WHERE screenName = :name")
    int getCountForUser(String name);
}
