package me.guillaume.duel;

import java.util.LinkedList;

public class Highlander extends Character {

    public Highlander() {
        this.hitPoints = 150;
        this.weaponValue = 12;
        this.equip = new LinkedList<>();
        this.rightHandWeapon = Weapon.GREATSWORD;
        this.experience = "";
    }

    public Highlander(String s) {
        this.hitPoints = 150;
        this.weaponValue = 12;
        this.equip = new LinkedList<>();
        this.rightHandWeapon = Weapon.GREATSWORD;
        this.experience = s;
    }

    public int hitPoints() {
        if (this.hitPoints <= 0)
            return 0;
        return this.hitPoints;
    }

    public Highlander equip(String s) {
        if (s.equals("buckler")) {
            this.equip.add(s);
            this.equipCounts = 100000;
            this.leftHandWeapon = Weapon.BUCKLER;
        }
        if (s.equals("armor")) {
            this.equip.add(s);
        }
        return this;
    }


}
