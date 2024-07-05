package com.connect4.model;

public class Player {
    private String name;
    private Colors color;

    public Player(String name, Colors color) {
        this.name = name;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public Colors getColor() {
        return color;
    }
}
