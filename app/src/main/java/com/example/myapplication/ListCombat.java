package com.example.myapplication;

import java.util.ArrayList;

public class ListCombat {
    ArrayList<Combat> list_combat;
    ListCharacters lc;

    public ListCombat(){
        lc.collection();
        this.list_combat=new ArrayList<Combat>();
        this.list_combat.add(new Combat(lc.list_c.get(19),lc.list_c.get(15),lc.list_c.get(16),0));
        this.list_combat.add(new Combat(lc.list_c.get(19),lc.list_c.get(15),lc.list_c.get(16),1));
        this.list_combat.add(new Combat(lc.list_c.get(19),lc.list_c.get(15),lc.list_c.get(16),2));
        this.list_combat.add(new Combat(lc.list_c.get(19),lc.list_c.get(15),lc.list_c.get(10),3));
        this.list_combat.add(new Combat(lc.list_c.get(19),lc.list_c.get(15),lc.list_c.get(11),4));
        this.list_combat.add(new Combat(lc.list_c.get(19),lc.list_c.get(15),lc.list_c.get(12),5));
        this.list_combat.add(new Combat(lc.list_c.get(19),lc.list_c.get(15),lc.list_c.get(13),6));
        this.list_combat.add(new Combat(lc.list_c.get(19),lc.list_c.get(15),lc.list_c.get(14),7));
    }

}
