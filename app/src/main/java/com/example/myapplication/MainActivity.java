package com.example.myapplication;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    Button Lancer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        Lancer =(Button)findViewById(R.id.button);
        Lancer.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View V){
                Intent otherActivity = new Intent (MainActivity.this, Page_Menu.class);
                startActivity(otherActivity);

            }
        });
    }
    public void go(View view){

        TextView output= findViewById(R.id.Affichage1);
        output.setText("t'as appuyé sur le bouton");


    }


}