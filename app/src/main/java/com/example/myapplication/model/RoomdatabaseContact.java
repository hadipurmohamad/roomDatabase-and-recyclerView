package com.example.myapplication.model;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Contact.class},version = 1,exportSchema = false)
public abstract class RoomdatabaseContact  extends RoomDatabase {
    public abstract ContactDao contactDao();
    private static volatile RoomdatabaseContact roomInstance;
    public static RoomdatabaseContact getInstance ( Context context){
        if (roomInstance == null){
            synchronized (RoomdatabaseContact.class){
                if (roomInstance==null){
                    roomInstance= Room.databaseBuilder(context.getApplicationContext()
                    ,RoomdatabaseContact.class,"contact_db")
                            .allowMainThreadQueries()
                            .build();
                }
            }
        }
     return roomInstance;
    }
}
