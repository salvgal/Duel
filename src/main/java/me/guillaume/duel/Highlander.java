package me.guillaume.duel;

import java.util.LinkedList;

public class Highlander extends Character {

    public Highlander() {
        this.hitPoints = 150;
        this.weaponValue = 12;
        this.equip = new LinkedList<>();
        this.experience = "";
    }

    public Highlander(String s) {
        this.hitPoints = 150;
        this.weaponValue = 12;
        this.equip = new LinkedList<>();
        this.experience = s;
    }

    public int hitPoints(){
        return this.hitPoints;
    }

    public Highlander equip(String s){
        if(s.equals("buckler")){
            this.equip.add(s);
            this.equipCounts +=7;
        }
        if(s.equals("armor")){
            this.equip.add(s);
        }
        return this;
    }


}
