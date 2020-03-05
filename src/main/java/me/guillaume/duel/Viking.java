package me.guillaume.duel;

import java.util.LinkedList;

public class Viking extends Character {

    public Viking() {
        this.hitPoints = 120;
        this.weaponValue = 6;
        this.equip = new LinkedList<>();
    }

    public int hitPoints(){
        return this.hitPoints;
    }

    public Viking equip(String s){
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
