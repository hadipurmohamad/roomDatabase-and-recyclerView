package com.example.myapplication.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

@Entity(tableName = "Contact_Table")
public class Contact {
    @PrimaryKey(autoGenerate = true)
    @NotNull
    @ColumnInfo(name="Id")
    private int Id ;

    public int getId() {
        return Id;
    }

    @ColumnInfo(name = "Name")
    private String Name;
    @ColumnInfo(name = "Occupation")
    private String Occupation;
    public Contact() {
    }

    public void setId(int id) {
        Id = id;
    }

    public Contact(@NotNull String name, String occupation) {
        this.Name = name;
       this.Occupation = occupation;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getOccupation() {
        return Occupation;
    }

    public void setOccupation(String occupation) {
        Occupation = occupation;
    }



}
