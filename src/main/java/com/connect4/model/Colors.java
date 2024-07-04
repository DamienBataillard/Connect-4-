package com.connect4.model;

public enum Colors {
    RED,
    YELLOW,
    BLUE,
    GREEN,
    ORANGE,
    PURPLE,
    PINK,
    CYAN,
    MAGENTA,
    LIME,
    TEAL,
    BROWN,
    BLACK,
    WHITE;

    @Override
    public String toString() {
        // Return the name of the color in lowercase
        return name().toLowerCase();
    }
}
