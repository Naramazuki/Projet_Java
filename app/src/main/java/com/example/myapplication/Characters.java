package com.example.myapplication;

import java.util.ArrayList;



public class Characters {
    int hp;
    int mana;
    String name;
    int mana_act;
    int hp_act;
    int id;
    int speed;
    int atk_p;
    int atk_m;
    int def_m;
    int def_p;
    boolean ally;
    ArrayList<Spell> p_spell;
    ArrayList<Spell> m_spell;
    int level;
    //int exp;
    //String class;

    public Characters(String name) {
        this.ally=true;
        this.name=name;
        this.hp=50;
        this.mana=50;
        this.id=id;
        this.mana_act=mana;
        this.hp_act=this.hp;
        this.speed=10;
        this.atk_m=10;
        this.atk_p=10;
        this.def_m=10;
        this.def_p=10;
        this.m_spell=new ArrayList<Spell>();
        this.p_spell=new ArrayList<Spell>();
    }

    public Characters(boolean ally,int hp, int mana,String name,int id,int speed,int def_m,int def_p,int atk_m,int atk_p) {
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
        this.mana_act=mana;
        this.m_spell=new ArrayList<Spell>();
        this.p_spell=new ArrayList<Spell>();
    }

    public void addSpell(Spell s){
        if(s.isPhysical()){
            this.p_spell.add(s);
        }
        else{
            this.m_spell.add(s);
        }
    }

    public int getDef_p() {
        return def_p;
    }

    public void setDef_p(int def_p) {
        this.def_p = def_p;
    }

    public int getDef_m() {
        return def_m;
    }

    public void setDef_m(int def_m) {
        this.def_m = def_m;
    }

    public int getAtk_m() {
        return atk_m;
    }

    public void setAtk_m(int atk_m) {
        this.atk_m = atk_m;
    }

    public int getAtk_p() {
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
        return name;
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

    public void levelup(){

    }
}
