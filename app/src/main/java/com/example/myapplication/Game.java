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
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import java.util.ArrayList;
import java.util.Random;


public class Game extends AppCompatActivity {
    //affichage du personnage qui joue
    public void get_character(int id,TextView mana, TextView Pv,ListCharacters listp,TextView Nom){



        mana.setText(listp.getTeam().get(id).mana_act+"/"+listp.getTeam().get(id).mana+"PM");
        Pv.setText(listp.getTeam().get(id).hp_act+"/"+listp.getTeam().get(id).hp+"PV");
        Nom.setText(listp.getTeam().get(id).name);


    }
    public ArrayList<Characters> restTeam(ListCharacters l, int[] i){
        ArrayList <Characters> rest_team= new ArrayList<>();
        for (int j = 0; j <3; j++) {
            if(j!=i[0] && l.getTeam().get(j).ally){
                rest_team.add(l.getTeam().get(j));

            }
        }
        return rest_team;
    }

    //choisir aléatoirement le fond de combat
    public int randBackground(int[] back){
        Random random=new Random();
        return back[random.nextInt(back.length)];
    }
    //recupère la liste des ennmies
    public ArrayList<Characters> getEnemy(ListCharacters l){
        ArrayList<Characters> ListEnemy = new ArrayList<>();
        for (int i = 3; i < l.getTeam().size() ; i++) {
            if(!l.getTeam().get(i).ally){
                ListEnemy.add(l.getTeam().get(i));

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
        ListView ListeMob=findViewById(R.id.ListeMob);
        GridView EnemyTeam=findViewById(R.id.Enemy_team);
        GridView Team=findViewById(R.id.Team);
        int [] characters={R.drawable.character,R.drawable.character3,R.drawable.character2};
        int [] Backgrounds={R.drawable.battle_background,R.drawable.background1,R.drawable.backgound2,R.drawable.background3,R.drawable.background4,R.drawable.background5};
        //creation du premier personnage et ajout des listes equipe et sort pour tests
        ListCharacters listp= new ListCharacters();

        listp.collection();
        listp.InitChara();


        ListSorts.setOnItemClickListener((adapterView, view, i, l) -> {
            ListSorts.setVisibility(View.INVISIBLE);
            ListeMob.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    Toast.makeText(getApplicationContext(),"taillade tes veines ",Toast.LENGTH_SHORT).show();
                }
            });

        });



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

            layout.setBackgroundResource(randBackground(Backgrounds));
            Entrer.setVisibility(View.INVISIBLE);
            Pseudo.setVisibility(View.INVISIBLE);
            interfaceCombat.setVisibility(View.VISIBLE);
            get_character(i[0],mana,Pv,listp,Nom);
            Team.setAdapter(new AdapterAlly(getApplicationContext(),restTeam(listp,i),characters));
            i[0]++;

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                bar.setProgress(100,true);
            }

            Toast.makeText(getApplicationContext(),"Bienvenue "+ Pseudo.getText().toString(),Toast.LENGTH_SHORT).show();
            bar.setVisibility(View.INVISIBLE);

            interfacePersonnage.setVisibility(View.VISIBLE);
            ListeMob.setVisibility(View.VISIBLE);
            ListeMob.setAdapter(new AdapterMob(getApplicationContext(),getEnemy(listp)));
            EnemyTeam.setAdapter(new AdapterEnemyLogo(getApplicationContext(),getEnemy(listp)));



        });

        Next.setOnClickListener(view -> {
            if (i[0] >= 3) {
                i[0] = 0;
            }
            i[1]=i[0];
            get_character(i[0],mana,Pv,listp,Nom);
            Team.setAdapter(new AdapterAlly(getApplicationContext(),restTeam(listp,i),characters));
            Toast.makeText(getApplicationContext(),"Bienvenue "+restTeam(listp,i).size(),Toast.LENGTH_SHORT).show();
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

        });


    }
}