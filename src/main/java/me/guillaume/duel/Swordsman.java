package me.guillaume.duel;

public class Swordsman extends Character {


    public Swordsman() {
        this.hitPoints = 100;
    }

    public Swordsman(String equip) {
        this.hitPoints = 100;
        this.equip = equip;
        this.equipCounts = 7;
    }

    @Override
    public void engage(Character c) {

        //Phase Swordman is fighting the Viking
        if(c instanceof Viking) {

            //use 1 hand sword - 17 hits
            for (int i = 0; i < 17; i++) {

                //buckler cancel all the damages of a blow
                if(equip!= null && equip.equals("buckler")){

                    //one time out of two
                    if(i%2==0){
                        this.equipCounts --;
                        continue;
                    }

                    //buckler is destroyed after blocking 3 blow
                    if(this.equipCounts==1){
                        this.equipCounts --;
                        this.equip = "";
                        continue;
                    }
                }

                //blow!
                c.hitPoints -= 5;

                //in case adversary is dead
                if (c.hitPoints <= 0) {
                    c.hitPoints = 0;
                    break;
                }
            }

            //let Viking respond to the Swordman - 17 hits
            for (int i = 0; i < 17; i++) {

                if (equip!= null && equals("buckler")) {

                    //one time out of two
                    if(i%2==0){
                        equipCounts --;
                        continue;
                    }

                    //buckler is destroyed after blocking 3 blow
                    if(equipCounts==1){
                        equipCounts --;
                        equip = "";
                        continue;
                    }
                }

                //blow!
                this.hitPoints -= 6;

                //in case adversary is dead
                if (this.hitPoints <= 0) {
                    this.hitPoints = 0;
                    break;
                }

                }
            }
    }

    public int hitPoints(){
        return this.hitPoints;
    }


    public Swordsman equip(String s){
        return new Swordsman(s);
    }

}
