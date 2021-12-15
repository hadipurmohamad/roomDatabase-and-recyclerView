package com.example.myapplication.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

import com.example.myapplication.R;

import org.w3c.dom.Text;

public class NewActivity extends AppCompatActivity {
private EditText name,occupation;
private Button btnSave;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);
        name=findViewById(R.id.edt_name);
        occupation=findViewById(R.id.edt_occupation);
        btnSave=findViewById(R.id.btn_save);
        Intent intent =new Intent();
        btnSave.setOnClickListener(view->{
            if (!name.getText().toString().isEmpty() && !occupation.getText().toString().isEmpty()){
      intent.putExtra("name",name.getText().toString());
      intent.putExtra("occupation",occupation.getText().toString());
      setResult(RESULT_OK,intent);
            }else {
             setResult(RESULT_CANCELED, intent);
            }
         finish();
        });
Bundle bundle = getIntent().getExtras();

      name.setText( bundle.getString("name"));
      occupation.setText( bundle.getString("occupation"));
    }
}