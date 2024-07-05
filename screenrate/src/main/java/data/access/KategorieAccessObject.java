package data.access;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import data.model.Kategorie;

@Dao
public interface KategorieAccessObject {
    @Query("SELECT * FROM Kategorie")
    List<Kategorie> getAll();
    @Insert(onConflict = OnConflictStrategy.ROLLBACK)
    void KategorieRegistrieren(Kategorie... kategorie);
    @Update
    void KategorieUpdate(List<Kategorie> kategorie);
}
