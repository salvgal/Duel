package me.guillaume.duel;

import java.util.LinkedList;

public class Swordsman extends Character {

    public Swordsman() {
        this.hitPoints = 100;
        this.equip = new LinkedList<>();
        this.rightHandWeapon = Weapon.SWORD;
        this.weaponValue = 5;
        this.experience = "";
    }

    public Swordsman(String s) {
        this.hitPoints = 100;
        this.equip = new LinkedList<>();
        this.rightHandWeapon = Weapon.SWORD;
        this.weaponValue = 5;
        this.experience = s;
    }

    public int hitPoints() {
        if (this.hitPoints <= 0)
            return 0;
        return this.hitPoints;
    }

    public Swordsman equip(String s) {
        if (s.equals("buckler")) {
            if (this.leftHandWeapon == null) {
                this.leftHandWeapon = Weapon.BUCKLER;
                this.equip.add(s);
                this.equipCounts = 100000;
            } else {
                this.rightHandWeapon = Weapon.BUCKLER;
                this.equip.add(s);
                this.equipCounts = 100000;
            }
        }
        if (s.equals("armor")) {
            this.equip.add(s);
        }
        if (s.equals("axe")) {
            if (this.leftHandWeapon == null) {
                this.leftHandWeapon = Weapon.AXE;
                this.weaponValue = Weapon.AXE.getDamage();
                this.equip.add(s);
            } else {
                this.rightHandWeapon = Weapon.AXE;
                this.weaponValue = Weapon.AXE.getDamage();
                this.equip.add(s);
            }
        }
        return this;
    }

}
