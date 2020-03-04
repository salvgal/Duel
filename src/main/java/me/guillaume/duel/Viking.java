package me.guillaume.duel;

public class Viking extends Character {

    public Viking() {
        this.hitPoints = 120;
    }

    public Viking(String equip) {
        this.hitPoints = 120;
        this.equip = equip;
        this.equipCounts = 7;
    }

    @Override
    public void engage(Character c) {

        //if Viking is fighting the Swordman
        if(c instanceof Swordsman) {

            //use 1 hand axe - 17 hits
            for (int i = 0; i < 17; i++) {

                //blow!
                c.hitPoints -= 6;

                //in case adversary is dead
                if (c.hitPoints <= 0) {
                    c.hitPoints = 0;
                    break;
                }
            }

            //let the adversary respond with a sword axe - 17 hits
            for (int i = 0; i < 17; i++) {

                this.hitPoints -= 5;

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

    public  Viking equip(String s){

        return new Viking(s);
    }


}
