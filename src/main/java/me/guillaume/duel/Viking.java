package me.guillaume.duel;

import java.util.LinkedList;

public class Viking extends Character {

    public Viking() {
        this.hitPoints = 120;
        this.weaponValue = 6;
        this.equip = new LinkedList<>();
        this.rightHandWeapon = Weapon.AXE;
        this.experience = "";
    }

    public Viking(String s) {
        this.hitPoints = 120;
        this.weaponValue = 6;
        this.equip = new LinkedList<>();
        this.rightHandWeapon = Weapon.AXE;
        this.experience = s;
    }

    public int hitPoints() {
        if (this.hitPoints <= 0)
            return 0;
        return this.hitPoints;
    }

    public Viking equip(String s) {
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
