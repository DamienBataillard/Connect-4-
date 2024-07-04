package com.connect4.model;

public class Cell {
    private int row;
    private int column;
    private Colors color;

    public Cell(int row, int column) {
        this.row = row;
        this.column = column;
        this.color = null; // Initialement, la cellule est vide
    }

    public void setColor(Colors color) {
        this.color = color;
    }

    public boolean isEmpty() {
        return this.color == null;
    }

    public Colors getColor() {
        return this.color;
    }
}
