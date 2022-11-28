package com.example.myapplication;

import java.lang.reflect.Array;

public class Spell {
    boolean physical;
    String name;
    int power;
    int rank;
    String description;
    int id;
    int cost;
    boolean aoe;

    public Spell() {
    }

    public Spell(boolean p,String name,int power,int rank,String description,int id,int cost){
        this.physical=p;
        this.name=name;
        this.power=power;
        this.rank=rank;
        this.description=description;
        this.id=id;
        this.cost=cost;
        this.aoe=false;

    }

    public Spell(boolean p,String name,int power,int rank,String description,int id,int cost,boolean aoe){
        this.physical=p;
        this.name=name;
        this.power=power;
        this.rank=rank;
        this.description=description;
        this.id=id;
        this.cost=cost;
        this.aoe=aoe;

    }

    public boolean isPhysical() {
        return physical;
    }

    public void setPhysical(boolean physical) {
        this.physical = physical;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }
}
