package com.example.myapplication;

import java.util.ArrayList;

import javax.xml.stream.events.Characters;

public class ListCharacters {
    ArrayList<Characters> list_c;
    ArrayList<Characters> team;

    public ListCharacters() {
        this.team=new ArrayList<Characters>();
        this.list_c=new ArrayList<Characters>();
    }

    public void addList(boolean ally,int hp, int mana,String name,int id,int speed,int def_m,int def_p,int atk_m,int atk_p){
        this.list_c.add(new Characters(ally,hp,mana,name,id,speed,def_m,def_p,atk_m,atk_p));
    }

    public void addTeam(Characters c){
            this.team.add(c);
    }

    public void removeTeam(int index){
        this.team.remove(index);
    }

    public ArrayList<Characters> getList_c() {
        return list_c;
    }

    public ArrayList<Characters> getTeam() {
        return team;
    }
}
