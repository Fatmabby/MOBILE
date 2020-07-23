package com.example.myinteractiveapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.text.BreakIterator;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText user,pass;
    Button login;
    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        user= findViewById(R.id.user);
        pass= findViewById(R.id.pass);
        spinner= findViewById(R.id.spinner);

        final ArrayList<String> role= new ArrayList<>();
        role.add("Administrator");
        role.add("Normal User");
        role.add("Manager");
        role.add("Executive Director");

       ArrayAdapter<String> adapter= new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,role);
        spinner.setAdapter(adapter);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(user.equals("")||pass.equals("")){
                Toast.makeText(getApplicationContext(),"fill all fields",Toast.LENGTH_SHORT).show();

            }else{



                SharedPreferences pref = getSharedPreferences("mydata", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = pref.edit();
                editor.putString("username", user.getText().toString());
                editor.putString("password", pass.getText().toString());
                editor.putString("role", spinner.toString());
                editor.commit();

                Toast.makeText(getApplicationContext(), "mydata", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(MainActivity.this,DetailedActivity.class);
                startActivity(intent);


            }
        }

        });

    }
}


