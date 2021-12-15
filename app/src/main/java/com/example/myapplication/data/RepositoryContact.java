package com.example.myapplication.data;

import android.content.Context;

import androidx.lifecycle.LiveData;

import com.example.myapplication.model.Contact;
import com.example.myapplication.model.RoomdatabaseContact;

import java.util.List;

public class RepositoryContact {
    private static RepositoryContact repositoryContact;
private Context context;
    private final LiveData<List<Contact>> listContact;

    public RepositoryContact(Context context){
        this.context= context;
      listContact = RoomdatabaseContact.getInstance(context.getApplicationContext()).contactDao().getAllData();

    }
  public LiveData<List<Contact>> getListAllContact(){
        return listContact;
  }
    public void  insertContact (Contact contact){
        RoomdatabaseContact.getInstance(context).contactDao().Insert(contact);
    }
    public void deleteAll(){
        RoomdatabaseContact.getInstance(context).contactDao().deleteAll();
    }
    public void deleteContact(int id){
//        RoomdatabaseContact.getInstance(context).contactDao().deletContact(id);
    }

}
