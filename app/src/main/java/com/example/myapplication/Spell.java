package com.example.myapplication;


public class Spell {
    boolean physical;
    String name="";
    int power=0;
    int rank=0;
    String description="";
    int id;
    int cost=0;
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
        return this.physical;
    }

    public void setPhysical(boolean physical) {
        this.physical = physical;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPower() {
        return this.power;
    }

    public void setPower(int power) {
        this.power = power;
    }
}
