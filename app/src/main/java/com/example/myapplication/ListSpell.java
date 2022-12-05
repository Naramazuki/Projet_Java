package com.example.myapplication;

import java.util.ArrayList;

public class ListSpell {
    ArrayList<Spell> list_s;

    public ListSpell(){
        this.list_s=new ArrayList<Spell>();
        list_s.add(new Spell(true,"Tree of life",9999,3,"Soigne complètement toute les unités présentes au combat",0,9999));
        list_s.add(new Spell(true,"Fireball",5,1,"Tire une boule sur un ennemi",1,5));
        list_s.add(new Spell(true,"Magma eruption",25,2,"Fait surgir sur l'équipe ennemie",2,30,true));
        list_s.add(new Spell(true,"Cataclysm",100,3,"Réduit les PV des ennemis de moitié",3,100));
        list_s.add(new Spell(true,"Mega Heal",25,2,"Rend des PV",4,50));
        list_s.add(new Spell(true,"Heal",10,1,"Rend une petite quantité de PV",5,10));
        list_s.add(new Spell(true,"Giga Heal",50,3,"Rend une grande quantité de PV",6,70));
        list_s.add(new Spell(true,"Def Up",25,1,"Augmente les défenses d'un allié",7,15));
        list_s.add(new Spell(true,"Omni Def Up",15,2,"Augmente les défenses de l'équipe",8,50,true));
        list_s.add(new Spell(true,"Atk Up",25,1,"Augmente les attaques d'un allié",9,15));
        list_s.add(new Spell(true,"Omni Atk Up",15,2,"Augmente les attaques de l'équipe",10,50,true));
        list_s.add(new Spell(true,"Up",20,1,"Augmente les attaques et les défenses d'un allié",11,15));
        list_s.add(new Spell(true,"Omni Up",10,2,"Augmente les attaques et les défenses de l'équipe",12,50,true));
        list_s.add(new Spell(true,"Def Up",25,1,"Augmente les défenses d'un allié",13,15));
        list_s.add(new Spell(true,"Resurge",0,2,"Permet à une unité d'agir directement",14,25));
        list_s.add(new Spell(true,"Fire Lance",15,2,"Tire une lance de feu sur un ennemi",15,10));
        list_s.add(new Spell(false,"Devastation",50,2,"Inlige de lour dégats sur une cible",16,25));
        list_s.add(new Spell(false,"Destruction",25,1,"Attaque simple infligeant des dégats",17,10));
        list_s.add(new Spell(false,"Aura of Doom",0,3,"Dégage une aura qui reduit les stats de moitié",18,100,true));
        list_s.add(new Spell(false,"Aura of Despair",0,2,"Dégage une aura qui réduit les stats d'un quart",19,50,true));
        list_s.add(new Spell(false,"Slash",10,1,"Exécute un coup nette avec une épée",20,5));
        list_s.add(new Spell(false,"Rain of sword",15,2,"Fait pleuvoir des coups d'épée sur les ennemis",21,15,true));
        list_s.add(new Spell(false,"Sword of true power",35,3,"Exécute un coup puissant avec une épée",22,20));
        list_s.add(new Spell(false,"Defence breaker",20,2,"Affaiblit les défenses de la cible",23,20));
        list_s.add(new Spell(false,"Omni Defence Breaker",15,2,"Exécute un coup ample pour affabilir les défenses",24,30));
        list_s.add(new Spell(false,"Block",0,2,"Prend une posture défensive et bloque tout dégat",25,20));
        list_s.add(new Spell(false,"Omni Block",0,3,"Protège toute l'équipe contre la prochaine attaque",26,50,true));
        list_s.add(new Spell(true,"Requiem",0,3,"Les ennemis meurent au bout de 10 tours",27,200));
        list_s.add(new Spell(true,"Bind",20,1,"Ralentit la cible",28,25));
        list_s.add(new Spell(true,"Omni Bind",15,2,"Ralentit les enemis",29,50,true));
        list_s.add(new Spell(false,"Aura of Savior",50,2,"Dégage une aura qui buff toute les caractéristique de l'équipe",30,70,true));
    }
}
