package me.guillaume.duel;

public abstract class Character {

     int hitPoints;
     String equip;
     int equipCounts;

     public abstract void engage(Character c);

//     public static Object equip(String s) {
//          return null;
//     }

     public abstract Object equip(String s);
}
