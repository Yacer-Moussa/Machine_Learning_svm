package data.model;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Anbieter")
public class Anbieter{

    public Anbieter() {
    }

    public void setName(@NonNull String name) {
        Name = name;
    }

    @PrimaryKey @NonNull
    private String Name;

    public Anbieter(String name){
        Name = name;
    }

    @NonNull
    public String getName() {
        return Name;
    }

    @Override
    public String toString() {
        return "Anbieter{" +
                "Name='" + Name + '\'' +
                '}';
    }
}
