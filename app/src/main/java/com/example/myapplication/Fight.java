package com.example.myapplication;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


public class Fight {
    ArrayList<Characters> Protagonists;
    ArrayList<Characters> Antagonists;
    ArrayList<Characters> sorted_Entity;
    Characters Characters_atm;
    int index_Characters_atm=0;
    int nb_turn=0;

    public void start_battle(){
        sorted_Entity=new ArrayList<>();
        sorted_Entity.addAll(Protagonists);
        sorted_Entity.addAll(Antagonists);
        Collections.sort(sorted_Entity,new Comparator<Characters>() {
            @Override
            public int compare(Characters c1, Characters c2){
                if (c1.getSpeed()<c2.getSpeed()){
                    return -1;
                }
                else if (c1.getSpeed()==c2.getSpeed()){
                    return 0;
                }
                else{
                    return 1;
                }
            }
        });
        Characters_atm=sorted_Entity.get(0);
    }

    public void start_action(){
        if (Protagonists.contains(Characters_atm)){
            //action
        }
        else{
            //IA action
            System.out.println("mais rien ne se passe");
        }
    }

    public void end_action(){
        index_Characters_atm++;
        if (index_Characters_atm<sorted_Entity.size()){
            Characters_atm=sorted_Entity.get(index_Characters_atm);
        }
        else{
            index_Characters_atm=0;
            Characters_atm=sorted_Entity.get(index_Characters_atm);
            for (int i=0;i<sorted_Entity.size();i++){
                sorted_Entity.get(i).setMana(Math.min((sorted_Entity.get(i).getMana()+20),sorted_Entity.get(i).getMana_max()));
            }
            nb_turn++;
        }
    }

    public boolean is_won(){
        for (int i=0;i<Antagonists.size();i++){
            if (Antagonists.get(i).getHp()>0){
                return false;
            }
        }
        end_fight();
        return true;
    }

    public boolean is_lost(){
        for (int i=0;i<Protagonists.size();i++){
            if (Protagonists.get(i).getHp()>0){
                return false;
            }
        }
        end_fight();
        return true;
    }

    public void end_fight(){
        System.out.println("Fin");
    }

    public void effet_spell_off_mono(Characters lanceur, Characters receveur,Spell sort){
        lanceur.setMana(lanceur.getMana()-sort.getCost());
        damages(receveur,sort);
    }

    public void effet_spell_soin_mono(Characters lanceur, Characters receveur,Spell sort){
        lanceur.setMana(lanceur.getMana()-sort.getCost());
        heal(receveur,sort);
    }

    public void damages(Characters receveur,Spell sort){
        if (sort.isMagical()){
            receveur.setHp(receveur.getHp()- (int)Math.max(0,sort.getPower()-receveur.getDef_m()) );
        }
        else{
            receveur.setHp(receveur.getHp()- (int)Math.max(0,sort.getPower()-receveur.getDef_p()) );
        }
    }

    public void heal(Characters receveur,Spell sort){
        receveur.setHp(Math.min(receveur.getHp()+sort.getPower(),receveur.getHp_max()));
    }
}
