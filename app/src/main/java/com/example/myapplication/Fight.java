package com.example.myapplication;

import java.util.ArrayList;
import java.util.Random;


public class Fight {
    ArrayList<Characters> Protagonists;
    ArrayList<Characters> Antagonists;
    Characters Characters_atm;
    int index_Characters_atm=0;
    boolean IsFisrt;
    ArrayList<Action> ActionList=new ArrayList<>();
    public void start_battle() {
        Action A;
        this.IsFisrt=isFirst();
        Characters_atm=Protagonists.get(0);

        if(!IsFisrt){
            A=mobAction(Antagonists.get(0));
            ActionList.add(A);
        }
    }
    //donne la première équipe qui va lancer les combats
    public boolean isFirst(){
        int maxAlly=Protagonists.get(0).speed;

        int maxEnemy=Antagonists.get(0).speed;


        for (int i = 0; i <Protagonists.size() ; i++) {
            if (Protagonists.get(i).speed>maxAlly){
                maxAlly=Protagonists.get(i).speed;

            }
            if (Antagonists.get(i).speed>maxEnemy){
                maxEnemy=Antagonists.get(i).speed;

            }

        }
        return(true);
    }
    public Action start_action(Characters Lanceur, Spell s,Characters Cible){
        Action a= new Action(Lanceur,s,Cible);
        return (a);
    }
    public void addAction(Action a){
        this.ActionList.add(a);

        if (index_Characters_atm<Protagonists.size() && !IsFisrt){

            this.ActionList.add(mobAction(Antagonists.get(index_Characters_atm+1)));
        }
        if (index_Characters_atm<Protagonists.size() && IsFisrt){
            this.ActionList.add(mobAction(Antagonists.get(index_Characters_atm)));
        }

    }
    public boolean end_action(){



            index_Characters_atm=0;
            Characters_atm=Protagonists.get(index_Characters_atm);
            for (int i=0;i<Protagonists.size();i++){
                Protagonists.get(i).setMana(Math.min((Protagonists.get(i).getMana()+20),Protagonists.get(i).getMana_max()));
                Antagonists.get(i).setMana(Math.min((Antagonists.get(i).getMana()+20),Antagonists.get(i).getMana_max()));


            }
            actionTour(ActionList);
            ActionList=new ArrayList<>();

            is_won();
            return true;

    }
    //effectue toutes les actions du tour
    public void actionTour(ArrayList<Action> ActionList){
        for (int i = 0; i <ActionList.size() ; i++) {
            this.damages(ActionList.get(i).Cible,ActionList.get(i).spell);
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
    public Action mobAction(Characters lanceur){
        Action A= new Action();
        Random rand= new Random();
        A.Lanceur=lanceur;
        if(rand.nextInt(2)==1){
            if(!lanceur.m_spell.isEmpty()){
                A.spell=lanceur.m_spell.get(rand.nextInt(lanceur.m_spell.size()));
            }
            else{
                A.spell=lanceur.p_spell.get(rand.nextInt(lanceur.p_spell.size()));
            }
            A.Cible=Protagonists.get(rand.nextInt(Protagonists.size()));
        }
        if(rand.nextInt(2)==0){
            if(!lanceur.p_spell.isEmpty()){
                A.spell=lanceur.p_spell.get(rand.nextInt(lanceur.p_spell.size()));
            }
            else{
                A.spell=lanceur.m_spell.get(rand.nextInt(lanceur.m_spell.size()));
            }
            A.Cible=Protagonists.get(rand.nextInt(Protagonists.size()));
        }
        return A;
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
            receveur.hp_act=(receveur.hp_act- (int)Math.max(0,sort.getPower()-receveur.getDef_m()) );
        }
        else{
            receveur.hp_act=(receveur.hp_act- (int)Math.max(0,sort.getPower()-receveur.getDef_p()) );
        }
    }

    public void heal(Characters receveur,Spell sort){
        receveur.setHp(Math.min(receveur.getHp()+sort.getPower(),receveur.getHp_max()));
    }

    private class Action {
        Spell spell=new Spell();
        Characters Lanceur;
        Characters Cible;
        public Action(){

        }
        public Action(Characters Lanceur, Spell sort,Characters Cible){
            this.Lanceur=Lanceur;
            this.spell=sort;
            this.Cible=Cible;
        }
    }
}
