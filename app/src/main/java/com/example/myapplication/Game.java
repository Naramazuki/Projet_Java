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

import java.util.ArrayList;
import java.util.Random;


public class Game extends AppCompatActivity {
    //affichage du personnage qui joue
    public void get_character(int id,TextView mana, TextView Pv,ListCharacters listp,TextView Nom,int []char_Icon_List,ImageView icon){



        mana.setText(listp.getTeam().get(id).mana_act+"/"+listp.getTeam().get(id).mana+"PM");
        Pv.setText(listp.getTeam().get(id).hp_act+"/"+listp.getTeam().get(id).hp+"PV");
        Nom.setText(listp.getTeam().get(id).name);
        icon.setBackgroundResource(char_Icon_List[id]);

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
    public ArrayList<Characters> restTeam(ArrayList<Characters> l, int[] i){
        ArrayList <Characters> rest_team= new ArrayList<>();
        for (int j = 0; j <3; j++) {
            if(j!=i[0] && l.get(j).ally){
                rest_team.add(l.get(j));

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
    public ArrayList<Characters> getAlly(ListCharacters l){
        ArrayList<Characters> ListEnemy = new ArrayList<>();
        for (int i = 0; i < 3 ; i++) {
            if(l.getTeam().get(i).ally){
                ListEnemy.add(l.getTeam().get(i));

            }

        }
        return(ListEnemy);
    }
    public int[] get_image(int[] charlist,int id){
        int[] chara= new int[2];
        int w=0;
        for (int i = 0; i <charlist.length ; i++) {
            if(i!=id){
                chara[w]=charlist[i];
                w++;
            }

        }
        return chara;

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
        ImageView icon= findViewById(R.id.Icon_Personnage);
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
        //Creation de toutes les variables necessaires
        ListCharacters listp= new ListCharacters();
        final int[] i = {0,0};
        Fight Deroulement=new Fight();

        //initialisation de la liste des personnages
        listp.collection();
        listp.InitChara();
        //initialisation des fonctions de deroulement du jeu
        Deroulement.Antagonists=getEnemy(listp);
        Deroulement.Protagonists=getAlly(listp);

        //action suite à la pression d'un sort
        ListSorts.setOnItemClickListener((adapterView, view, Position, l) -> {
            ListSorts.setVisibility(View.INVISIBLE);
            Spell s=(Spell) ListSorts.getAdapter().getItem(Position);

            //Toast.makeText(getApplicationContext()," Sort: "+ s.name,Toast.LENGTH_SHORT).show();
            //Toast.makeText(getApplicationContext()," Lanceur: "+ Deroulement.Protagonists.get(i[0]).name,Toast.LENGTH_SHORT).show();
            ListeMob.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int Position, long l) {
                    Characters mob=(Characters) ListeMob.getAdapter().getItem(Position);
                    interfaceCombat.setVisibility(View.VISIBLE);
                    Deroulement.addAction(Deroulement.start_action(Deroulement.Characters_atm,s,mob));
                    //Toast.makeText(getApplicationContext()," Mob: "+ mob.name,Toast.LENGTH_SHORT).show();
                    Toast.makeText(getApplicationContext()," ListAction: "+ Deroulement.ActionList.size(),Toast.LENGTH_SHORT).show();

                    i[0]++;


                    //affchage du personnage suivant
                    if(i[0]==3) {

                        if (Deroulement.end_action()) {
                            //si fin  de tour on effectue la mise à jour des pv et du mana des personnages
                            i[0] = 0;
                            ListeMob.setAdapter(new AdapterMob(getApplicationContext(), Deroulement.Antagonists));
                            System.out.println("ok");


                        }
                    }
                    Deroulement.Characters_atm=Deroulement.Protagonists.get(i[0]);
                    Deroulement.index_Characters_atm=i[0];
                    i[1]=i[0];
                    get_character(i[0],mana,Pv,listp,Nom,characters,icon);
                    Team.setAdapter(new AdapterAlly(getApplicationContext(),restTeam(Deroulement.Protagonists,i),get_image(characters,i[0])));


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





        Entrer.setOnClickListener(view -> {

            layout.setBackgroundResource(randBackground(Backgrounds));
            Entrer.setVisibility(View.INVISIBLE);
            Pseudo.setVisibility(View.INVISIBLE);
            interfaceCombat.setVisibility(View.VISIBLE);
            Deroulement.start_battle();

            get_character(i[0],mana,Pv,listp,Nom,characters,icon);
            Team.setAdapter(new AdapterAlly(getApplicationContext(),restTeam(Deroulement.Protagonists,i),get_image(characters,i[0])));


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