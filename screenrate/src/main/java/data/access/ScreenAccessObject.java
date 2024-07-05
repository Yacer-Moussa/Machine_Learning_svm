package data.access;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import data.model.Screen;

@Dao
public interface ScreenAccessObject {
    @Query("SELECT * FROM Screen")
    List<Screen> getAll();
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void ScreenSchreiben(Screen screen);
    @Update
    void ScreenUpdate(List<Screen> screen);

    @Query("SELECT COUNT(*) FROM screen")
    int getScreenCount();
    @Query("SELECT Name FROM screen WHERE ScreenID = :screenID")
    String getScreenName(int screenID);
}
