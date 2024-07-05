package data.access;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import data.model.Anbieter;

@Dao
public interface AnbieterAccessObject {
    @Query("SELECT * FROM Anbieter")
    List<Anbieter> getAll();

    @Insert(onConflict = OnConflictStrategy.ROLLBACK)
    void AnbieterRegistrieren(Anbieter... anbieter);
    @Update
    void AnbieterUpdate(List<Anbieter> anbieter);
}
