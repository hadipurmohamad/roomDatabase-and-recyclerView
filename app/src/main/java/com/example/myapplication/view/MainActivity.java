package com.example.myapplication.view;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.service.autofill.LuhnChecksumValidator;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.myapplication.R;
import com.example.myapplication.data.ContactViewModel;
import com.example.myapplication.model.Contact;
import com.example.myapplication.model.ContactDao;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class MainActivity extends AppCompatActivity implements RecyclerContact.RecycelerGetposition {
public ContactDao contactDao;
private ContactViewModel viewModel;
String Name,Occupation;
public FloatingActionButton fbv;
private RecyclerView recyclerView;
private RecyclerContact recyclerContact;
private      LiveData<List<Contact>> contactList ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fbv = findViewById(R.id.floatingActionButton);
        recyclerView=findViewById(R.id.recycler_items);
        LiveData<List<Contact>> contactList ;
        viewModel  = new ViewModelProvider.AndroidViewModelFactory(MainActivity.this.getApplication()).create(ContactViewModel.class);

        contactList=viewModel.getAlldata();
        contactList.observe(this, contacts -> Log.d("HF", "onChanged: "+contacts.size()));
        ActivityResultLauncher<Intent> activityResultLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                result -> {
                  if (result.getResultCode()==RESULT_OK){
                      assert result.getData() != null;
                      Bundle data = result.getData().getExtras();
                  Name=data.getString("name");
                  Occupation=data.getString("occupation");
                  Contact contact=new Contact(Name,Occupation);
                  viewModel.insertContact(contact);
                  }else{
                      Toast.makeText(MainActivity.this,"Please Enter Information",Toast.LENGTH_SHORT).show();
                  }
                }) ;
viewModel.getAlldata().observe(this, contacts -> {

     recyclerContact=new RecyclerContact(contacts,this);
    recyclerView.setHasFixedSize(true);
    recyclerView.setLayoutManager(new LinearLayoutManager(this));
    recyclerView.setAdapter(recyclerContact);
});
        fbv.setOnClickListener(view->{
            Intent intent=new Intent(this,NewActivity.class);
activityResultLauncher.launch(intent);
        });
    }

    @Override
    public void getposition(int position){
        viewModel.getAlldata().observe(this, new Observer<List<Contact>>() {
            @Override
            public void onChanged(List<Contact> contacts) {

        String sendName=contacts.get(position).getName();
        String sendOccupation=contacts.get(position).getOccupation();
Intent intent = new Intent(MainActivity.this,NewActivity.class);
intent.putExtra("name",sendName);
intent.putExtra("occupation",sendOccupation);
startActivity(intent);
            }
        });

    }
}
