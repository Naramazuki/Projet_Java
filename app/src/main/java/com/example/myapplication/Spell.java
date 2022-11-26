package com.example.myapplication;

import java.lang.reflect.Array;

public class Spell {
    boolean physical;
    String name;
    int power;

    public Spell() {
    }

    public Spell(boolean p,String name,int power){
        this.physical=p;
        this.name=name;
        this.power=power;
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
