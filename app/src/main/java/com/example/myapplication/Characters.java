package com.example.myapplication;

import java.util.ArrayList;



public class Characters {
    int hp;
    int mana;
    String name;
    int id;
    int speed;
    int mana_act;
    int hp_act;
    double atk_p;
    double atk_m;
    double def_m;
    double def_p;
    boolean ally;
    ArrayList<Spell> p_spell;
    ArrayList<Spell> m_spell;
    int level;
    int exp_needed;
    int exp_given;

    public Characters() {
    }

    public Characters(boolean ally,int hp, int mana,String name,int id,int speed,double def_m,double def_p,double atk_m,double atk_p) {
        this.hp=hp;
        this.mana=mana;
        this.name=name;
        this.id=id;
        this.speed=speed;
        this.atk_m=atk_m;
        this.atk_p=atk_p;
        this.def_m=def_m;
        this.def_p=def_p;
        this.ally=ally;
        this.hp_act=this.hp;
        this.mana_act=this.mana;
        this.m_spell=new ArrayList<Spell>();
        this.p_spell=new ArrayList<Spell>();
        this.level=1;
        this.exp_needed=1;
        this.exp_given=1;
    }

    public Characters(boolean ally,int hp, int mana,String name,int id,int speed,double def_m,double def_p,double atk_m,double atk_p,int exp_given) {
        this.hp=hp;
        this.mana=mana;
        this.name=name;
        this.id=id;
        this.speed=speed;
        this.atk_m=atk_m;
        this.atk_p=atk_p;
        this.def_m=def_m;
        this.def_p=def_p;
        this.ally=ally;
        this.hp_act=this.hp;
        this.mana_act=this.mana;
        this.m_spell=new ArrayList<Spell>();
        this.p_spell=new ArrayList<Spell>();
        this.level=1;
        this.exp_needed=1;
        this.exp_given=exp_given;
    }

    public void lvlup(Characters c){
        c.hp=c.hp*2;
        c.mana=c.mana*2;
        c.speed=c.speed++;
        c.atk_m=c.atk_m*1.5;
        c.atk_p=c.atk_p*1.5;
        c.def_m=c.def_m*1.5;
        c.def_p=c.def_p*1.5;
        c.level++;
        c.exp_needed=c.level;

    }

    public void addSpell(Spell s){
        if(s.isMagical()){
            this.m_spell.add(s);
        }
        else{
            this.p_spell.add(s);
        }
    }

    public double getDef_p() {
        return def_p;
    }

    public void setDef_p(int def_p) {
        this.def_p = def_p;
    }

    public double getDef_m() {
        return def_m;
    }

    public void setDef_m(int def_m) {
        this.def_m = def_m;
    }

    public double getAtk_m() {
        return atk_m;
    }

    public void setAtk_m(int atk_m) {
        this.atk_m = atk_m;
    }

    public double getAtk_p() {
        return atk_p;
    }

    public void setAtk_p(int atk_p) {
        this.atk_p = atk_p;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }
    public int getHp_max(){
        return hp;
    }
    public int getMana_max(){
        return mana;


    }
}
