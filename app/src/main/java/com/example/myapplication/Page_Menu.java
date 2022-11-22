package com.example.myapplication;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Page_Menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page_menu);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        TextView username=findViewById(R.id.Username);
        TextView password=findViewById(R.id.Password);
        Button loginbtn=findViewById(R.id.Connexion);

        loginbtn.setOnClickListener(view -> {
            if(username.getText().toString().equals("admin")&& password.getText().toString().equals("admin")){
                Toast.makeText(getApplicationContext(),"CONNEXION REUSSIE",Toast.LENGTH_SHORT).show();
                Intent gamelaunch = new Intent (Page_Menu.this, Game.class);
                startActivity(gamelaunch);
            }
            else{
                Toast.makeText(getApplicationContext(),"CONNEXION ECHOUE",Toast.LENGTH_SHORT).show();
            }
        });



    }
}