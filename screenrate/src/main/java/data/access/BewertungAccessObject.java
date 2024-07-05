package data.access;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;


import java.util.List;

import data.model.Bewertung;

@Dao
public interface BewertungAccessObject {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void BewertungSchreiben(Bewertung bewertung);
    @Update
    void BewertungUpdate(List<Bewertung> bewertung);
    @Query("SELECT * FROM Bewertung")
    List<Bewertung> getAll();
}
