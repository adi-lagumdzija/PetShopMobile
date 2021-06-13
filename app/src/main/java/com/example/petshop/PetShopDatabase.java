package com.example.petshop;
import android.content.Context;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {User.class}, version = 1)
public abstract class PetShopDatabase extends RoomDatabase{
    private static PetShopDatabase petShopDatabase;

    public static PetShopDatabase getPetShopDatabase (Context context){
        if(petShopDatabase == null){
            petShopDatabase = Room.databaseBuilder(context, PetShopDatabase.class, "petshop").allowMainThreadQueries().build();
        }
        return petShopDatabase;
    }
    public abstract UserDao userDao();
}
