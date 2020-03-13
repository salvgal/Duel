package me.guillaume.duel;

public enum Buckler {
    SWORD(1);

    Buckler(int protect) {
        this.protect = protect;
    }

    private final int protect;

    public int getProtect() {
        return protect;
    }

    public int protect() {
        return protect;
    }
}

