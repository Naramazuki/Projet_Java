package com.example.myapplication;

import java.util.ArrayList;


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

    public void collection(ListCharacters l){
        ListSpell ls = new ListSpell();
        l.addList(true,100,25,"Barret",0,10,75,75,30,30);
        l.list_c.get(0).addSpell(ls.list_s.get(1));
        l.list_c.get(0).addSpell(ls.list_s.get(15));
        l.list_c.get(0).addSpell(ls.list_s.get(7));
        l.list_c.get(0).addSpell(ls.list_s.get(14));

        l.addList(true,25,100,"Bibi",1,80,10,10,100,1);
        l.list_c.get(1).addSpell(ls.list_s.get(1));
        l.list_c.get(1).addSpell(ls.list_s.get(2));
        l.list_c.get(1).addSpell(ls.list_s.get(15));
        l.list_c.get(1).addSpell(ls.list_s.get(4));
        l.list_c.get(1).addSpell(ls.list_s.get(5));

        l.addList(true,50,50,"Tidus",2,50,40,40,40,40);
        l.list_c.get(2).addSpell(ls.list_s.get(14));
        l.list_c.get(2).addSpell(ls.list_s.get(20));
        l.list_c.get(2).addSpell(ls.list_s.get(8));
        l.list_c.get(2).addSpell(ls.list_s.get(9));

        l.addList(true,45,75,"Yuna",3,70,80,20,60,10);
        l.list_c.get(3).addSpell(ls.list_s.get(6));
        l.list_c.get(3).addSpell(ls.list_s.get(5));
        l.list_c.get(3).addSpell(ls.list_s.get(11));
        l.list_c.get(3).addSpell(ls.list_s.get(12));

        l.addList(true,75,30,"Sephiroth",4,85,5,5,5,100);
        l.list_c.get(4).addSpell(ls.list_s.get(20));
        l.list_c.get(4).addSpell(ls.list_s.get(21));
        l.list_c.get(4).addSpell(ls.list_s.get(22));
        l.list_c.get(4).addSpell(ls.list_s.get(23));

        l.addList(true,60,65,"Noctis",5,60,55,55,60,60);
        l.list_c.get(5).addSpell(ls.list_s.get(20));
        l.list_c.get(5).addSpell(ls.list_s.get(15));
        l.list_c.get(5).addSpell(ls.list_s.get(25));
        l.list_c.get(5).addSpell(ls.list_s.get(28));

        l.addList(true,80,40,"Cloud",6,45,45,65,10,70);
        l.list_c.get(6).addSpell(ls.list_s.get(20));
        l.list_c.get(6).addSpell(ls.list_s.get(21));
        l.list_c.get(6).addSpell(ls.list_s.get(22));
        l.list_c.get(6).addSpell(ls.list_s.get(23));

        l.addList(true,65,55,"Tifa",7,65,35,35,55,65);
        l.list_c.get(7).addSpell(ls.list_s.get(9));
        l.list_c.get(7).addSpell(ls.list_s.get(11));
        l.list_c.get(7).addSpell(ls.list_s.get(1));
        l.list_c.get(7).addSpell(ls.list_s.get(15));

        l.addList(true,65,65,"Lightning",8,75,25,25,75,75);
        l.list_c.get(8).addSpell(ls.list_s.get(29));
        l.list_c.get(8).addSpell(ls.list_s.get(30));
        l.list_c.get(8).addSpell(ls.list_s.get(2));
        l.list_c.get(8).addSpell(ls.list_s.get(1));

        l.addList(true,90,40,"Cid",9,45,50,50,40,20);
        l.list_c.get(9).addSpell(ls.list_s.get(8));
        l.list_c.get(9).addSpell(ls.list_s.get(7));
        l.list_c.get(9).addSpell(ls.list_s.get(26));
        l.list_c.get(9).addSpell(ls.list_s.get(23));

        l.addList(false,10000,400,"Nergigante",10,50,100,100,40,40,2);
        l.list_c.get(10).addSpell(ls.list_s.get(3));
        l.list_c.get(10).addSpell(ls.list_s.get(17));
        l.list_c.get(10).addSpell(ls.list_s.get(16));

        l.addList(false,10000,400,"Magnamalo",11,50,100,100,40,40,2);
        l.list_c.get(11).addSpell(ls.list_s.get(16));
        l.list_c.get(11).addSpell(ls.list_s.get(17));
        l.list_c.get(11).addSpell(ls.list_s.get(18));
        
        l.addList(false,10000,400,"Rakna Khadaki",12,50,100,100,40,40,2);
        l.list_c.get(12).addSpell(ls.list_s.get(16));
        l.list_c.get(13).addSpell(ls.list_s.get(17));
        l.list_c.get(13).addSpell(ls.list_s.get(19));

        l.addList(false,10000,400,"Kushala Daora",13,50,100,100,40,40,2);
        l.list_c.get(14).addSpell(ls.list_s.get(16));
        l.list_c.get(14).addSpell(ls.list_s.get(17));
        l.list_c.get(14).addSpell(ls.list_s.get(27));

        l.addList(false,10000,400,"Zorah Magdaros",14,50,100,100,40,40,2);
        l.list_c.get(15).addSpell(ls.list_s.get(16));
        l.list_c.get(15).addSpell(ls.list_s.get(17));
        l.list_c.get(15).addSpell(ls.list_s.get(3));

        l.addList(false,115,30,"Mog",15,30,25,50,25,15,1);
        l.list_c.get(16).addSpell(ls.list_s.get(1));
        l.list_c.get(16).addSpell(ls.list_s.get(20));
        l.list_c.get(16).addSpell(ls.list_s.get(2));

        l.addList(false,150,25,"Gobelins",16,55,15,15,5,80,1);
        l.list_c.get(17).addSpell(ls.list_s.get(20));
        l.list_c.get(17).addSpell(ls.list_s.get(28));
        l.list_c.get(17).addSpell(ls.list_s.get(1));

        l.addList(true,9999,9999,"Hero test",1,1,1,1,1,1);
        l.list_c.get(18).addSpell(ls.list_s.get(0));
        l.list_c.get(18).addSpell(ls.list_s.get(1));
        l.list_c.get(18).addSpell(ls.list_s.get(2));
        l.list_c.get(18).addSpell(ls.list_s.get(3));
        l.list_c.get(18).addSpell(ls.list_s.get(4));
        l.list_c.get(18).addSpell(ls.list_s.get(5));
        l.list_c.get(18).addSpell(ls.list_s.get(6));
        l.list_c.get(18).addSpell(ls.list_s.get(7));
        l.list_c.get(18).addSpell(ls.list_s.get(8));
        l.list_c.get(18).addSpell(ls.list_s.get(9));
        l.list_c.get(18).addSpell(ls.list_s.get(10));
        l.list_c.get(18).addSpell(ls.list_s.get(11));
        l.list_c.get(18).addSpell(ls.list_s.get(12));
        l.list_c.get(18).addSpell(ls.list_s.get(13));
        l.list_c.get(18).addSpell(ls.list_s.get(14));
        l.list_c.get(18).addSpell(ls.list_s.get(15));
        l.list_c.get(18).addSpell(ls.list_s.get(16));
        l.list_c.get(18).addSpell(ls.list_s.get(17));
        l.list_c.get(18).addSpell(ls.list_s.get(18));
        l.list_c.get(18).addSpell(ls.list_s.get(19));
        l.list_c.get(18).addSpell(ls.list_s.get(20));
        l.list_c.get(18).addSpell(ls.list_s.get(21));
        l.list_c.get(18).addSpell(ls.list_s.get(22));
        l.list_c.get(18).addSpell(ls.list_s.get(23));
        l.list_c.get(18).addSpell(ls.list_s.get(24));
        l.list_c.get(18).addSpell(ls.list_s.get(25));
        l.list_c.get(18).addSpell(ls.list_s.get(26));
        l.list_c.get(18).addSpell(ls.list_s.get(27));
        l.list_c.get(18).addSpell(ls.list_s.get(28));
        l.list_c.get(18).addSpell(ls.list_s.get(29));
        l.list_c.get(18).addSpell(ls.list_s.get(30));

        l.addList(false,9999,9999,"Boss test",1,1,1,1,1,1);
        l.list_c.get(18).addSpell(ls.list_s.get(0));
        l.list_c.get(18).addSpell(ls.list_s.get(1));
        l.list_c.get(18).addSpell(ls.list_s.get(2));
        l.list_c.get(18).addSpell(ls.list_s.get(3));
        l.list_c.get(18).addSpell(ls.list_s.get(4));
        l.list_c.get(18).addSpell(ls.list_s.get(5));
        l.list_c.get(18).addSpell(ls.list_s.get(6));
        l.list_c.get(18).addSpell(ls.list_s.get(7));
        l.list_c.get(18).addSpell(ls.list_s.get(8));
        l.list_c.get(18).addSpell(ls.list_s.get(9));
        l.list_c.get(18).addSpell(ls.list_s.get(10));
        l.list_c.get(18).addSpell(ls.list_s.get(11));
        l.list_c.get(18).addSpell(ls.list_s.get(12));
        l.list_c.get(18).addSpell(ls.list_s.get(13));
        l.list_c.get(18).addSpell(ls.list_s.get(14));
        l.list_c.get(18).addSpell(ls.list_s.get(15));
        l.list_c.get(18).addSpell(ls.list_s.get(16));
        l.list_c.get(18).addSpell(ls.list_s.get(17));
        l.list_c.get(18).addSpell(ls.list_s.get(18));
        l.list_c.get(18).addSpell(ls.list_s.get(19));
        l.list_c.get(18).addSpell(ls.list_s.get(20));
        l.list_c.get(18).addSpell(ls.list_s.get(21));
        l.list_c.get(18).addSpell(ls.list_s.get(22));
        l.list_c.get(18).addSpell(ls.list_s.get(23));
        l.list_c.get(18).addSpell(ls.list_s.get(24));
        l.list_c.get(18).addSpell(ls.list_s.get(25));
        l.list_c.get(18).addSpell(ls.list_s.get(26));
        l.list_c.get(18).addSpell(ls.list_s.get(27));
        l.list_c.get(18).addSpell(ls.list_s.get(28));
        l.list_c.get(18).addSpell(ls.list_s.get(29));
        l.list_c.get(18).addSpell(ls.list_s.get(30));


    }

    public Characters duplicate(int index){
        Characters tempo =this.list_c.get(index);
        Characters res = new Characters(tempo.ally, tempo.hp, tempo.mana, tempo.name, tempo.id, tempo.speed, tempo.def_m, tempo.def_p, tempo.atk_m, tempo.atk_p);
        return res;
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
