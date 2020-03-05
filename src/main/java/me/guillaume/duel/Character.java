package me.guillaume.duel;

import java.util.List;

public abstract class Character {

    int hitPoints;
    int weaponValue;
    List<String> equip;
    int equipCounts;
    String experience;

    public abstract Object equip(String s);

    public void engage(Character c) {

        //Phase 1: Player 1 attack and Player 2 defense

        //use 1 hand sword - 17 hits
        for (int i = 1; i <= 17; i++) {

            //buckler cancel all the damages of a blow
            if (c.equip != null && c.equip.contains("buckler")) {

                //one time out of two
                if (i % 2 == 0) {
                    c.equipCounts--;
                    continue;
                }

                //buckler is destroyed after blocking 3 blow
                if (c.equipCounts == 0) {
                    c.equip.remove("buckler");
                }
            }

            //blow!
            if(this.weaponValue==12){
                if(i%3!=0) {
                    if (this.equip.contains("armor")) {
                        c.hitPoints -= this.weaponValue-1;
                    } else {
                        c.hitPoints -= this.weaponValue;
                    }
                }
            }
            else{
                 if(this.equip.contains("armor")){
                     if(i%2==1){
                         c.hitPoints -= (this.weaponValue-1)*3;
                     }else{
                         c.hitPoints -= this.weaponValue-1;
                     }
                 }else{
                      c.hitPoints -= this.weaponValue;
                 }
            }


            //in case adversary is dead
            if (c.hitPoints <= 0) {
                c.hitPoints = 0;
                break;
            }
        }

        //Phase 2: Player 2 attack and Player 1 defense
        for (int i = 1; i <= 17; i++) {

            if (this.equip != null && this.equip.contains("buckler")) {

                //one time out of two
                if (i % 2 == 0) {
                    this.equipCounts--;
                    continue;
                }

                //buckler is destroyed after blocking 3 blow
                if (this.equipCounts == 0) {
                    this.equip.remove("buckler");
                }
            }

            //blow!
             if(c.weaponValue==12){
                  if(i%3!=0){
                       if(this.equip.contains("armor")){
                            this.hitPoints -= c.weaponValue-3;
                       }else{
                            this.hitPoints -= c.weaponValue;
                       }
                  }
             }
             else{
                  if(this.equip.contains("armor")){
                       this.hitPoints -= c.weaponValue-3;
                  }else{
                       this.hitPoints -= c.weaponValue;
                  }
             }

            //in case adversary is dead
            if (this.hitPoints <= 0) {
                this.hitPoints = 0;
                break;
            }

        }
    }
}
