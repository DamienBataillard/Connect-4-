package com.connect4.model;

public class Board {
    private Cell[][] gridBoard;

    public Board() {
        gridBoard = new Cell[6][7]; // Taille du plateau de jeu
        for (int row = 0; row < 6; row++) {
            for (int column = 0; column < 7; column++) {
                gridBoard[row][column] = new Cell(row, column);
            }
        }
    }

    public boolean dropPiece(int column, Colors color) {
        for (int row = 5; row >= 0; row--) {
            if (gridBoard[row][column].isEmpty()) {
                gridBoard[row][column].setColor(color);
                return true;
            }
        }
        return false; // La colonne est pleine
    }

    public boolean isColumnFull(int column) {
        return !gridBoard[0][column].isEmpty();
    }

    public void displayGrid() {
        for (int row = 0; row < 6; row++) {
            for (int column = 0; column < 7; column++) {
                if (gridBoard[row][column].isEmpty()) {
                    System.out.print(". ");
                } else {
                    System.out.print(gridBoard[row][column].getColor().toString().charAt(0) + " ");
                }
            }
            System.out.println();
        }
    }

    public boolean checkPuissance4(Colors color) {
        // Vérifier les lignes pour une victoire
        for (int row = 0; row < 6; row++) {
            for (int col = 0; col < 4; col++) {
                if (gridBoard[row][col].getColor() == color &&
                    gridBoard[row][col + 1].getColor() == color &&
                    gridBoard[row][col + 2].getColor() == color &&
                    gridBoard[row][col + 3].getColor() == color) {
                    return true;
                }
            }
        }

        // Vérifier les colonnes pour une victoire
        for (int col = 0; col < 7; col++) {
            for (int row = 0; row < 3; row++) {
                if (gridBoard[row][col].getColor() == color &&
                    gridBoard[row + 1][col].getColor() == color &&
                    gridBoard[row + 2][col].getColor() == color &&
                    gridBoard[row + 3][col].getColor() == color) {
                    return true;
                }
            }
        }

        // Vérifier les diagonales (de bas-gauche à haut-droit)
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 4; col++) {
                if (gridBoard[row][col].getColor() == color &&
                    gridBoard[row + 1][col + 1].getColor() == color &&
                    gridBoard[row + 2][col + 2].getColor() == color &&
                    gridBoard[row + 3][col + 3].getColor() == color) {
                    return true;
                }
            }
        }

        // Vérifier les diagonales (de haut-gauche à bas-droit)
        for (int row = 3; row < 6; row++) {
            for (int col = 0; col < 4; col++) {
                if (gridBoard[row][col].getColor() == color &&
                    gridBoard[row - 1][col + 1].getColor() == color &&
                    gridBoard[row - 2][col + 2].getColor() == color &&
                    gridBoard[row - 3][col + 3].getColor() == color) {
                    return true;
                }
            }
        }

        return false;
    }

    public boolean isBoardFull() {
        for (int column = 0; column < 7; column++) {
            if (!isColumnFull(column)) {
                return false;
            }
        }
        return true;
    }

    public void reinitializeGrid() {
        for (int row = 0; row < 6; row++) {
            for (int column = 0; column < 7; column++) {
                gridBoard[row][column].setColor(null);
            }
        }
    }
}
