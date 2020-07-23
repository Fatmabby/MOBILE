package com.example.myinteractiveapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class DetailedActivity extends AppCompatActivity {
    Button logout;
    TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed2);
        logout= findViewById(R.id.logout);
        result =findViewById(R.id.result);

        SharedPreferences pref = getSharedPreferences("result", Context.MODE_PRIVATE);
        String username = pref.getString("username","");
        String role = pref.getString("role","");
        result.setText("WELCOME"+username+":"+role);

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences pref = getSharedPreferences("result",Context.MODE_PRIVATE);
                SharedPreferences.Editor edit= pref.edit();
                edit.clear();
                edit.clear();
                edit.commit();
                Intent intent =new Intent(DetailedActivity.this,MainActivity.class);
                startActivity(intent);
                Toast.makeText(getApplicationContext(),"Data  Cleared Successfully",Toast.LENGTH_SHORT).show();
            }
        });
    }
}