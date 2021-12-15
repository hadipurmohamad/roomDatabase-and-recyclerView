package com.example.myapplication.model;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface ContactDao  {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    public void  Insert(Contact contact);
 @Query("DELETE FROM Contact_Table")
    public void deleteAll();

 @Query("SELECT * FROM Contact_Table")
public LiveData<List<Contact>> getAllData();
@Delete
 void delete(Contact contact);
@Update
    void update(Contact contact);
@Query("SELECT * FROM Contact_Table WHERE Id=:id")
public Contact getContact(int id);

}
