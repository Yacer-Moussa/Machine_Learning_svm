package data.model;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;
@Entity(tableName = "Kategorie")
public class Kategorie {

    public void setName(@NonNull String name) {
        Name = name;
    }

    @PrimaryKey @NonNull
    private String Name;

    public Kategorie(String name){
        Name = name;
    }


    public Kategorie() {
    }

    public String getName(){
        return Name;
    }

    @Override
    public String toString() {
        return "Kategorie{" +
                "Name='" + Name + '\'' +
                '}';
    }
}
