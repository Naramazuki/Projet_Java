package com.example.myapplication;

import java.util.ArrayList;
import java.util.Random;


public class ListCharacters {
    ArrayList<Characters> list_c;
    ArrayList<Characters> team;
    ListSpell ls ;

    public ListCharacters() {
        this.team=new ArrayList<Characters>();
        this.list_c=new ArrayList<Characters>();
        this.ls = new ListSpell();

    }

    public void addList(boolean ally,int hp, int mana,String name,int id,int speed,int def_m,int def_p,int atk_m,int atk_p){
        this.list_c.add(new Characters(ally,hp,mana,name,id,speed,def_m,def_p,atk_m,atk_p));
    }

    public void collection(){
        this.addList(true,100,25,"Barret",0,10,75,75,30,30);
        this.list_c.get(0).addSpell(ls.list_s.get(1));
        this.list_c.get(0).addSpell(ls.list_s.get(15));
        this.list_c.get(0).addSpell(ls.list_s.get(7));
        this.list_c.get(0).addSpell(ls.list_s.get(14));


        this.addList(true,25,100,"Bibi",1,80,10,10,100,1);
        this.list_c.get(1).addSpell(ls.list_s.get(1));
        this.list_c.get(1).addSpell(ls.list_s.get(2));
        this.list_c.get(1).addSpell(ls.list_s.get(15));
        this.list_c.get(1).addSpell(ls.list_s.get(4));
        this.list_c.get(1).addSpell(ls.list_s.get(5));

        this.addList(true,50,50,"Tidus",2,50,40,40,40,40);
        this.list_c.get(2).addSpell(ls.list_s.get(14));
        this.list_c.get(2).addSpell(ls.list_s.get(20));
        this.list_c.get(2).addSpell(ls.list_s.get(8));
        this.list_c.get(2).addSpell(ls.list_s.get(9));

        this.addList(true,45,75,"Yuna",3,70,80,20,60,10);
        this.list_c.get(3).addSpell(ls.list_s.get(6));
        this.list_c.get(3).addSpell(ls.list_s.get(5));
        this.list_c.get(3).addSpell(ls.list_s.get(11));
        this.list_c.get(3).addSpell(ls.list_s.get(12));

        this.addList(true,75,30,"Sephiroth",4,85,5,5,5,100);
        this.list_c.get(4).addSpell(ls.list_s.get(20));
        this.list_c.get(4).addSpell(ls.list_s.get(21));
        this.list_c.get(4).addSpell(ls.list_s.get(22));
        this.list_c.get(4).addSpell(ls.list_s.get(23));

        this.addList(true,60,65,"Noctis",5,60,55,55,60,60);
        this.list_c.get(5).addSpell(ls.list_s.get(20));
        this.list_c.get(5).addSpell(ls.list_s.get(15));
        this.list_c.get(5).addSpell(ls.list_s.get(25));
        this.list_c.get(5).addSpell(ls.list_s.get(28));

        this.addList(true,80,40,"Cloud",6,45,45,65,10,70);
        this.list_c.get(6).addSpell(ls.list_s.get(20));
        this.list_c.get(6).addSpell(ls.list_s.get(21));
        this.list_c.get(6).addSpell(ls.list_s.get(22));
        this.list_c.get(6).addSpell(ls.list_s.get(23));

        this.addList(true,65,55,"Tifa",7,65,35,35,55,65);
        this.list_c.get(7).addSpell(ls.list_s.get(9));
        this.list_c.get(7).addSpell(ls.list_s.get(11));
        this.list_c.get(7).addSpell(ls.list_s.get(1));
        this.list_c.get(7).addSpell(ls.list_s.get(15));

        this.addList(true,65,65,"Lightning",8,75,25,25,75,75);
        this.list_c.get(8).addSpell(ls.list_s.get(29));
        this.list_c.get(8).addSpell(ls.list_s.get(30));
        this.list_c.get(8).addSpell(ls.list_s.get(2));
        this.list_c.get(8).addSpell(ls.list_s.get(1));

        this.addList(true,90,40,"Cid",9,45,50,50,40,20);
        this.list_c.get(9).addSpell(ls.list_s.get(8));
        this.list_c.get(9).addSpell(ls.list_s.get(7));
        this.list_c.get(9).addSpell(ls.list_s.get(26));
        this.list_c.get(9).addSpell(ls.list_s.get(23));

        this.addList(false,10000,400,"Nergigante",10,50,100,100,40,40);
        this.list_c.get(10).addSpell(ls.list_s.get(3));
        this.list_c.get(10).addSpell(ls.list_s.get(17));
        this.list_c.get(10).addSpell(ls.list_s.get(16));

        this.addList(false,10000,400,"Magnamalo",11,50,100,100,40,40);
        this.list_c.get(11).addSpell(ls.list_s.get(16));
        this.list_c.get(11).addSpell(ls.list_s.get(17));
        this.list_c.get(11).addSpell(ls.list_s.get(18));
        
        this.addList(false,10000,400,"Rakna Khadaki",12,50,100,100,40,40);
        this.list_c.get(12).addSpell(ls.list_s.get(16));
        this.list_c.get(12).addSpell(ls.list_s.get(17));
        this.list_c.get(12).addSpell(ls.list_s.get(19));

        this.addList(false,10000,400,"Kushala Daora",13,50,100,100,40,40);
        this.list_c.get(13).addSpell(ls.list_s.get(16));
        this.list_c.get(13).addSpell(ls.list_s.get(17));
        this.list_c.get(13).addSpell(ls.list_s.get(27));

        this.addList(false,10000,400,"Zorah Magdaros",14,50,100,100,40,40);
        this.list_c.get(14).addSpell(ls.list_s.get(16));
        this.list_c.get(14).addSpell(ls.list_s.get(17));
        this.list_c.get(14).addSpell(ls.list_s.get(3));

        this.addList(false,115,30,"Mog",15,30,25,50,25,15);
        this.list_c.get(15).addSpell(ls.list_s.get(1));
        this.list_c.get(15).addSpell(ls.list_s.get(20));
        this.list_c.get(15).addSpell(ls.list_s.get(2));

        this.addList(false,150,25,"Gobelins",16,55,15,15,5,80);
        this.list_c.get(16).addSpell(ls.list_s.get(20));
        this.list_c.get(16).addSpell(ls.list_s.get(28));
        this.list_c.get(16).addSpell(ls.list_s.get(1));

        this.addList(true,9999,9999,"Hero test",17,1,1,1,1,1);
        this.list_c.get(17).addSpell(ls.list_s.get(0));
        this.list_c.get(17).addSpell(ls.list_s.get(1));
        this.list_c.get(17).addSpell(ls.list_s.get(2));
        this.list_c.get(17).addSpell(ls.list_s.get(3));
        this.list_c.get(17).addSpell(ls.list_s.get(4));
        this.list_c.get(17).addSpell(ls.list_s.get(5));
        this.list_c.get(17).addSpell(ls.list_s.get(6));
        this.list_c.get(17).addSpell(ls.list_s.get(7));
        this.list_c.get(17).addSpell(ls.list_s.get(8));
        this.list_c.get(17).addSpell(ls.list_s.get(9));
        this.list_c.get(17).addSpell(ls.list_s.get(10));
        this.list_c.get(17).addSpell(ls.list_s.get(11));
        this.list_c.get(17).addSpell(ls.list_s.get(12));
        this.list_c.get(17).addSpell(ls.list_s.get(13));
        this.list_c.get(17).addSpell(ls.list_s.get(14));
        this.list_c.get(17).addSpell(ls.list_s.get(15));
        this.list_c.get(17).addSpell(ls.list_s.get(16));
        this.list_c.get(17).addSpell(ls.list_s.get(17));
        this.list_c.get(17).addSpell(ls.list_s.get(18));
        this.list_c.get(17).addSpell(ls.list_s.get(19));
        this.list_c.get(17).addSpell(ls.list_s.get(20));
        this.list_c.get(17).addSpell(ls.list_s.get(21));
        this.list_c.get(17).addSpell(ls.list_s.get(22));
        this.list_c.get(17).addSpell(ls.list_s.get(23));
        this.list_c.get(17).addSpell(ls.list_s.get(24));
        this.list_c.get(17).addSpell(ls.list_s.get(25));
        this.list_c.get(17).addSpell(ls.list_s.get(26));
        this.list_c.get(17).addSpell(ls.list_s.get(27));
        this.list_c.get(17).addSpell(ls.list_s.get(28));
        this.list_c.get(17).addSpell(ls.list_s.get(29));
        this.list_c.get(17).addSpell(ls.list_s.get(30));

        this.addList(false,9999,9999,"Boss test",18,1,1,1,1,1);
        this.list_c.get(18).addSpell(ls.list_s.get(0));
        this.list_c.get(18).addSpell(ls.list_s.get(1));
        this.list_c.get(18).addSpell(ls.list_s.get(2));
        this.list_c.get(18).addSpell(ls.list_s.get(3));
        this.list_c.get(18).addSpell(ls.list_s.get(4));
        this.list_c.get(18).addSpell(ls.list_s.get(5));
        this.list_c.get(18).addSpell(ls.list_s.get(6));
        this.list_c.get(18).addSpell(ls.list_s.get(7));
        this.list_c.get(18).addSpell(ls.list_s.get(8));
        this.list_c.get(18).addSpell(ls.list_s.get(9));
        this.list_c.get(18).addSpell(ls.list_s.get(10));
        this.list_c.get(18).addSpell(ls.list_s.get(11));
        this.list_c.get(18).addSpell(ls.list_s.get(12));
        this.list_c.get(18).addSpell(ls.list_s.get(13));
        this.list_c.get(18).addSpell(ls.list_s.get(14));
        this.list_c.get(18).addSpell(ls.list_s.get(15));
        this.list_c.get(18).addSpell(ls.list_s.get(16));
        this.list_c.get(18).addSpell(ls.list_s.get(17));
        this.list_c.get(18).addSpell(ls.list_s.get(18));
        this.list_c.get(18).addSpell(ls.list_s.get(19));
        this.list_c.get(18).addSpell(ls.list_s.get(20));
        this.list_c.get(18).addSpell(ls.list_s.get(21));
        this.list_c.get(18).addSpell(ls.list_s.get(22));
        this.list_c.get(18).addSpell(ls.list_s.get(23));
        this.list_c.get(18).addSpell(ls.list_s.get(24));
        this.list_c.get(18).addSpell(ls.list_s.get(25));
        this.list_c.get(18).addSpell(ls.list_s.get(26));
        this.list_c.get(18).addSpell(ls.list_s.get(27));
        this.list_c.get(18).addSpell(ls.list_s.get(28));
        this.list_c.get(18).addSpell(ls.list_s.get(29));
        this.list_c.get(18).addSpell(ls.list_s.get(30));

        this.addList(false,150,25,"Gobelin junior",16,55,15,15,5,80);
        this.list_c.get(19).addSpell(ls.list_s.get(20));
        this.list_c.get(19).addSpell(ls.list_s.get(28));
        this.list_c.get(19).addSpell(ls.list_s.get(1));

    }

    public Characters duplicate(int index){
        Characters tempo =this.list_c.get(index);
        return tempo;
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
    public void InitChara(){

        int index;
        Random rand= new Random();


        for (int i=0;i<3;i++) {
            index = rand.nextInt(10);
            this.addTeam(this.list_c.get(index));
        }
        for (int i2=0;i2<3;i2++){
            index=rand.nextInt(9);
            this.addTeam(this.list_c.get(10+index));
        }


}}
