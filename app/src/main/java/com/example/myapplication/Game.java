package com.example.myapplication;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

public class Game extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        Button Entrer = findViewById(R.id.Entrer);
        TextView Pseudo = findViewById(R.id.Pseudo);
        ConstraintLayout layout=findViewById(R.id.Background);

        Entrer.setOnClickListener(view -> {
            layout.setBackgroundResource(R.drawable.battle_background);
            Entrer.setVisibility(View.INVISIBLE);
            Pseudo.setVisibility(View.INVISIBLE);
            Toast.makeText(getApplicationContext(),"Bienvenue "+ Pseudo.getText().toString(),Toast.LENGTH_SHORT).show();
        });

    }
}