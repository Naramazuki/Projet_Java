package com.example.myapplication;


import android.content.pm.ActivityInfo;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.example.myapplication.databinding.ActivityMainBinding;

import java.util.ArrayList;


public class Game extends AppCompatActivity {
    public void get_character(int id,TextView mana, TextView Pv,ListCharacters listp,TextView Nom){



        mana.setText(listp.getTeam().get(id).mana_act+"/"+listp.getTeam().get(id).mana+"PM");
        Pv.setText(listp.getTeam().get(id).hp_act+"/"+listp.getTeam().get(id).hp+"PV");
        Nom.setText(listp.getTeam().get(id).name);


    }
    //faire changement de la structure d'affichae des personnages et utiliser gridview qui facilite grandement la tache
    public void personnage(TextView nom,TextView pv, ProgressBar pvBar,ImageView icon){
        if(nom.getVisibility()==View.VISIBLE){
            nom.setVisibility(View.INVISIBLE);
            pv.setVisibility(View.INVISIBLE);
            pvBar.setVisibility(View.INVISIBLE);
            icon.setVisibility(View.INVISIBLE);
        }
        else{
            nom.setVisibility(View.VISIBLE);
            pv.setVisibility(View.VISIBLE);
            pvBar.setVisibility(View.VISIBLE);
            icon.setVisibility(View.VISIBLE);
        }
    }
    public ArrayList<Characters> getEnemy(ListCharacters l){
        ArrayList<Characters> ListEnemy = new ArrayList<>();
        for (int i = 0; i < l.getTeam().size() ; i++) {
            if(!l.getTeam().get(i).ally){
                ListEnemy.add(l.getTeam().get(i));
                System.out.println(l.getTeam().get(i).name);
            }

        }
        return(ListEnemy);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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
        Button Attaquer=findViewById(R.id.ATTAQUER);
        GridView ListSorts=findViewById(R.id.List_sort);
        ImageView imagePerso=findViewById(R.id.ImagePerso);
        TextView nomEnnemy = findViewById(R.id.Nom_Ennemie);
        TextView pvEnnemy = findViewById(R.id.Pv_Ennemy);
        ProgressBar Pv_Ennemy = findViewById(R.id.PvBar_Ennemy);
        ImageView iconEnnemy = findViewById(R.id.Icon_Ennemy);
        ListView ListeMob=findViewById(R.id.ListeMob);


        //creation du premier personnage et ajout des listes equipe et sort pour tests
        ListCharacters listp= new ListCharacters();
        ListSpell lists= new ListSpell();

        listp.collection();
        listp.InitChara();

        //fixer l'adapter
        ListSorts.setOnItemClickListener((adapterView, view, i, l) -> {
            ListSorts.setVisibility(View.INVISIBLE);
            ListeMob.setVisibility(View.VISIBLE);
            ListeMob.setAdapter(new AdapterMob(getApplicationContext(),getEnemy(listp)));

        });
        ListeMob.setOnItemClickListener((adapterView, view, i, l) -> {
            // mettre en place interaction avec les pVs
            Toast.makeText(getApplicationContext(),"taillade tes veines ",Toast.LENGTH_SHORT).show();

        });
                // faire une gridwiew listmob

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



        final int[] i = {0,0};

        Entrer.setOnClickListener(view -> {

            layout.setBackgroundResource(R.drawable.battle_background);
            Entrer.setVisibility(View.INVISIBLE);
            Pseudo.setVisibility(View.INVISIBLE);
            interfaceCombat.setVisibility(View.VISIBLE);
            get_character(i[0],mana,Pv,listp,Nom);
            i[0]++;

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                bar.setProgress(100,true);
            }

            Toast.makeText(getApplicationContext(),"Bienvenue "+ Pseudo.getText().toString(),Toast.LENGTH_SHORT).show();
            bar.setVisibility(View.INVISIBLE);

            interfacePersonnage.setVisibility(View.VISIBLE);
            imagePerso.setVisibility(View.VISIBLE);

        });

        Next.setOnClickListener(view -> {
            if (i[0] >= 3) {
                i[0] = 0;
            }
            i[1]=i[0];
            get_character(i[0],mana,Pv,listp,Nom);
            i[0]++;
        });
        Sorts.setOnClickListener(view -> {
            Next.setVisibility(View.INVISIBLE);
            ListSorts.setVisibility(View.VISIBLE);
            interfaceCombat.setVisibility(View.INVISIBLE);
            retour.setVisibility(View.VISIBLE);
            ListSorts.setAdapter(new MyAdapter(this,listp.getTeam().get(i[1]).m_spell));


        });
        Attaquer.setOnClickListener(view -> {
            Next.setVisibility(View.INVISIBLE);
            ListSorts.setVisibility(View.VISIBLE);
            interfaceCombat.setVisibility(View.INVISIBLE);
            retour.setVisibility(View.VISIBLE);
            ListSorts.setAdapter(new MyAdapter(this,listp.getTeam().get(i[1]).p_spell));

        });
        retour.setOnClickListener(view -> {
            ListSorts.setVisibility(View.INVISIBLE);
            interfaceCombat.setVisibility(View.VISIBLE);
            retour.setVisibility(View.INVISIBLE);
            Next.setVisibility(View.VISIBLE);
            ListeMob.setVisibility(View.INVISIBLE);
        });


    }
}