package me.guillaume.duel;

import java.util.List;

public abstract class Character {

    int hitPoints;
    int weaponValue;
    Weapon leftHandWeapon;
    Weapon rightHandWeapon;
    List<String> equip;
    int equipCounts;
    String experience;

    public abstract Object equip(String s);

    public void engage(Character c) {

        if (this.equip.size() == 0 && c.equip.size() == 0) {
            //Test case 1 - fight settings
            fight1(c);
        } else if (this.equip.contains("buckler") && c.equip.contains("buckler")) {
            //Test case 2  - fight settings
            fight2(c);
        } else if (this.equip.contains("buckler") && this.equip.contains("armor") && !this.equip.contains("axe") && c.equip.size() == 0) {
            //Test case 3  - fight settings
            fight3(c);
        } else if (this.equip.contains("buckler") && this.equip.contains("armor") && this.equip.contains("axe") && this.experience == "Vicious" && c.experience == "Veteran") {
            //Test case 4  - fight settings
            fight4(c);
        }
    }

    private void fight1(Character c) {
        while (this.hitPoints > 0 && c.hitPoints > 0) {
            //Partner A attack Partner B
            c.hitPoints -= this.rightHandWeapon.getDamage();
            //Partner B respond
            this.hitPoints -= c.rightHandWeapon.getDamage();
        }
    }

    private void fight2(Character c) {
        int i = -1;

        //Buckler is vulnerable to axes
        if (c.rightHandWeapon == Weapon.AXE)
            this.equipCounts = 3;

        while (this.hitPoints > 0 && c.hitPoints > 0) {

            if (this.equip.contains("buckler") && c.equip.contains("buckler")) {
                if (i % 2 == 1) {
                    this.equipCounts--;
                    if (this.equipCounts <= 0)
                        this.equip.remove("buckler");
                } else {
                    //Partner A attack Partner B
                    c.hitPoints -= this.rightHandWeapon.getDamage();
                    //Partner B respond
                    this.hitPoints -= c.rightHandWeapon.getDamage();
                    this.equipCounts--;
                    if (this.equipCounts <= 0)
                        this.equip.remove("buckler");

                }
            } else if (!this.equip.contains("buckler") && c.equip.contains("buckler")) {
                if (i % 2 == 1) {
                    this.hitPoints -= c.rightHandWeapon.getDamage();
                } else {
                    //Partner A attack Partner B
                    c.hitPoints -= this.rightHandWeapon.getDamage();
                    //Partner B respond
                    this.hitPoints -= c.rightHandWeapon.getDamage();
                }
            } else {
                //Partner A attack Partner B
                c.hitPoints -= this.rightHandWeapon.getDamage();
                //Partner B respond
                this.hitPoints -= c.rightHandWeapon.getDamage();
            }
            i++;
        }
    }

    private void fight3(Character c) {
        int i = 1; //cause the Great Sword
        int j = 1; //cause the buckler
        while (this.hitPoints > 0 && c.hitPoints > 0) {
            if (i % 3 != 0) {
                if (j % 2 == 0) {
                    //Partner A attack Partner B
                    c.hitPoints -= this.rightHandWeapon.getDamage() - 1;
                } else {
                    //Partner A attack Partner B
                    c.hitPoints -= this.rightHandWeapon.getDamage() - 1;
                    //Partner B respond
                    this.hitPoints -= c.rightHandWeapon.getDamage() - 3;
                }
            } else {
                //Partner A attack Partner B
                c.hitPoints -= this.rightHandWeapon.getDamage() - 1;
            }
            i++;
            j++;
        }
    }

    private void fight4(Character c) {

        int i = 1; //cause the Great Sword
        int j = 1; //cause the buckler
        int p = 1; //poison of vicious Swordsman
        int berserkLevel = c.hitPoints * 30 / 100;
        while (this.hitPoints > 0 && c.hitPoints > 0) {
            if (i % 3 != 0) {
                if (j % 2 == 0) {
                    //Partner A attack Partner B
                    if (p <= 2) {
                        c.hitPoints -= this.leftHandWeapon.getDamage() - 1 + 20;
                        p++;
                    } else {
                        c.hitPoints -= this.leftHandWeapon.getDamage() - 1;
                    }
                } else {
                    //Partner A attack Partner B
                    if (p <= 2) {
                        c.hitPoints -= this.leftHandWeapon.getDamage() - 1 + 20;
                        p++;
                    } else {
                        c.hitPoints -= this.leftHandWeapon.getDamage() - 1;
                    }
                    //Partner B respond
                    if (c.hitPoints <= berserkLevel) {
                        this.hitPoints -= ((c.rightHandWeapon.getDamage() * 2) - 3);
                    } else {
                        this.hitPoints -= c.rightHandWeapon.getDamage() - 3;
                    }
                }
            } else {
                //Partner A attack Partner B
                if (p <= 2) {
                    c.hitPoints -= this.leftHandWeapon.getDamage() - 1 + 20;
                    p++;
                } else {
                    c.hitPoints -= this.leftHandWeapon.getDamage() - 1;
                }
            }
            i++;
            j++;
        }
    }
}
