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

    public void makeMove(Board board, int column) {
        if (board.dropPiece(column, color)) {
            System.out.println(name + " a placé une pièce dans la colonne " + column);
        } else {
            System.out.println("Colonne " + column + " est pleine. Essayez une autre colonne.");
        }
    }
}
