package me.guillaume.duel;

import java.util.LinkedList;

public class Swordsman extends Character {


    public Swordsman() {
        this.hitPoints = 100;
        this.weaponValue = 5;
        this.equip = new LinkedList<>();
        this.experience = "";
        this.rightHandWeapon = Weapon.SWORD;
    }

    public Swordsman(String s) {
        this.hitPoints = 100;
        this.weaponValue = 5;
        this.equip = new LinkedList<>();
        this.experience = s;
        this.rightHandWeapon = Weapon.SWORD;
    }

    public int hitPoints(){
        if(this.hitPoints <= 0 )
            return 0;
        return this.hitPoints;
    }

    public Swordsman equip(String s){
        if(s.equals("buckler")) {
            this.equip.add(s);
            this.equipCounts =3;
        }
        if(s.equals("armor")){
            this.equip.add(s);
        }
        return this;
    }

}
