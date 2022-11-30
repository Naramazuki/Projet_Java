package com.example.myapplication;

import android.content.pm.ActivityInfo;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import java.util.ArrayList;


public class Game extends AppCompatActivity {
    public void get_character(int id,TextView mana, TextView Pv,ListCharacters listp,TextView Nom){



        mana.setText(listp.getTeam().get(id).mana_act+"/"+listp.getTeam().get(id).mana+"PM");
        Pv.setText(listp.getTeam().get(id).hp_act+"/"+listp.getTeam().get(id).hp+"PV");
        Nom.setText(listp.getTeam().get(id).name);
    }
    //faire fonction d'affichage des ennemies et des alliés


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final int[] i = {0};
        setContentView(R.layout.activity_game);
        //Mise au format paysage
        View overlay=findViewById(R.id.Background);
        overlay.setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION|View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY|View.SYSTEM_UI_FLAG_FULLSCREEN);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        //Déclaration des balises utilisées dans nos fonctions
        Button Entrer = findViewById(R.id.Entrer);
        EditText Pseudo = findViewById(R.id.Pseudo);
        TextView mana = findViewById(R.id.Mana);
        TextView Pv = findViewById(R.id.Pv);
        Button Next=findViewById(R.id.NextChara);
        Button Sorts=findViewById(R.id.SORTS);
        Button retour=findViewById(R.id.retour);
        ConstraintLayout layout=findViewById(R.id.Background);
        TableLayout interfaceCombat= findViewById(R.id.IntfCombat);
        ProgressBar bar =findViewById(R.id.progressBar3);
        TableLayout interfacePersonnage=findViewById(R.id.personnage);
        TextView Nom=findViewById(R.id.Nom);
        GridView ListSorts=findViewById(R.id.List_sort);
        ImageView imagePerso=findViewById(R.id.ImagePerso);

        //creation du premier personnage et ajout des liste equipe et sort pour tests
        ListCharacters listp= new ListCharacters();
        listp.addTeam(new Characters("deji"));
        ListSpell lists= new ListSpell();
        int maxspeed=listp.getTeam().get(0).speed;
        int id=0;
        for(int w=1;w<listp.getTeam().size();w++) {
            if(listp.getTeam().get(w).speed>maxspeed){
                maxspeed=listp.getTeam().get(w).speed;
                id=w;

            }

        }



            ListSorts.setAdapter(new MyAdapter(this,lists.list_s));



        Pseudo.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                Entrer.setEnabled(!Pseudo.getText().toString().trim().isEmpty());
            }

            @Override
            public void afterTextChanged(Editable editable) {


            }
        });


        int finalId = id;
        Entrer.setOnClickListener(view -> {
            listp.addTeam(new Characters(Pseudo.getText().toString()));

            layout.setBackgroundResource(R.drawable.battle_background);
            Entrer.setVisibility(View.INVISIBLE);
            Pseudo.setVisibility(View.INVISIBLE);
            interfaceCombat.setVisibility(View.VISIBLE);
            get_character(finalId,mana,Pv,listp,Nom);

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                bar.setProgress(100,true);
            }

            Toast.makeText(getApplicationContext(),"Bienvenue "+ Pseudo.getText().toString(),Toast.LENGTH_SHORT).show();
            bar.setVisibility(View.INVISIBLE);

            interfacePersonnage.setVisibility(View.VISIBLE);
            imagePerso.setVisibility(View.VISIBLE);

        });

        //retirer fonction next et le bouton qui va avec
        Next.setOnClickListener(view -> {
            if(i[0]<listp.getTeam().size()){
                get_character(i[0],mana,Pv,listp,Nom);
                i[0]++;

            }

            else {
                i[0]=0;
                get_character(i[0],mana,Pv,listp,Nom);
            }



        });
        Sorts.setOnClickListener(view -> {
            ListSorts.setVisibility(View.VISIBLE);
            interfaceCombat.setVisibility(View.INVISIBLE);
            retour.setVisibility(View.VISIBLE);
        });
        retour.setOnClickListener(view -> {
            ListSorts.setVisibility(View.INVISIBLE);
            interfaceCombat.setVisibility(View.VISIBLE);
            retour.setVisibility(View.INVISIBLE);

        });


    }
}