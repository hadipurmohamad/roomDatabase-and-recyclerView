package com.example.myapplication.data;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.myapplication.model.Contact;

import java.util.List;

public class ContactViewModel extends AndroidViewModel {
    private final RepositoryContact repositoryContact;
    private final LiveData<List<Contact>> Alldata;
    public ContactViewModel(@NonNull Application application) {
        super(application);
         repositoryContact = new RepositoryContact(application);
         Alldata=repositoryContact.getListAllContact();
    }
    public LiveData<List<Contact>> getAlldata(){return Alldata;}
    public void insertContact (Contact contact){repositoryContact.insertContact(contact);}
    public void deleteAll(){repositoryContact.deleteAll();}
    public void deleteContact(int id){repositoryContact.deleteContact(id);}
}
