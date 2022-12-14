package com.example.myapplication;

import java.util.ArrayList;

public class Combat {
    ArrayList<Characters> list_mob;
    Boolean cleared;
    int id;

    public Combat() {
    }

    public Combat(Characters c1, Characters c2, Characters c3,int id){
        this.list_mob=new ArrayList<Characters>();
        this.list_mob.add(c1);
        this.list_mob.add(c2);
        this.list_mob.add(c3);
        this.cleared=false;
        this.id=id;
    }

    public Boolean isCleared(){
        return this.cleared;
    }

    public Boolean Clear(){
        int hp_c1=this.list_mob.get(0).hp_act;
        int hp_c2=this.list_mob.get(1).hp_act;
        int hp_c3=this.list_mob.get(2).hp_act;
        return (hp_c1==0) && (hp_c2==0) && (hp_c3==0);
    }

}