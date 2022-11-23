package com.example.myapplication;

import android.content.pm.ActivityInfo;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

public class Game extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_game);
        View overlay=findViewById(R.id.Background);
        overlay.setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION|View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY|View.SYSTEM_UI_FLAG_FULLSCREEN);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        Button Entrer = findViewById(R.id.Entrer);
        TextView Pseudo = findViewById(R.id.Pseudo);
        ConstraintLayout layout=findViewById(R.id.Background);
        TableLayout interfaceCombat= findViewById(R.id.IntfCombat);
        ProgressBar bar =findViewById(R.id.progressBar3);
        TableLayout interfacePersonnage=findViewById(R.id.personnage);
        TextView Nom=findViewById(R.id.Nom);
        Entrer.setOnClickListener(view -> {
            layout.setBackgroundResource(R.drawable.battle_background);
            Entrer.setVisibility(View.INVISIBLE);
            Pseudo.setVisibility(View.INVISIBLE);
            interfaceCombat.setVisibility(View.VISIBLE);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                bar.setProgress(100,true);
            }
            Toast.makeText(getApplicationContext(),"Bienvenue "+ Pseudo.getText().toString(),Toast.LENGTH_SHORT).show();
            bar.setVisibility(View.INVISIBLE);
            Nom.setText(Pseudo.getText().toString());
            interfacePersonnage.setVisibility(View.VISIBLE);

        });

    }
}