package me.guillaume.duel;

public enum Weapon {
    SWORD(5),
    AXE(6);

    Weapon(int damage) {
        this.damage = damage;
    }

    private final int damage;

    public int getDamage() {
        return damage;
    }
}

