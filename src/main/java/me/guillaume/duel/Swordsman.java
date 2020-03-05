package me.guillaume.duel;

import java.util.LinkedList;

public class Swordsman extends Character {


    public Swordsman() {
        this.hitPoints = 100;
        this.weaponValue = 5;
        this.equip = new LinkedList<>();
        this.experience = "";
    }

    public Swordsman(String s) {
        this.hitPoints = 100;
        this.weaponValue = 5;
        this.equip = new LinkedList<>();
        this.experience = s;
    }

    public int hitPoints(){
        return this.hitPoints;
    }


    public Swordsman equip(String s){
        if(s.equals("buckler")) {
            this.equip.add(s);
            this.equipCounts = 0;
        }
        if(s.equals("armor")){
            this.equip.add(s);
        }
        return this;
    }

}
