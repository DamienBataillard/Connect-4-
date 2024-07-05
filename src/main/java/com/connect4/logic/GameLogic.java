package com.connect4.logic;

import com.connect4.model.Board;
import com.connect4.model.Player;

public class GameLogic {

    public void makeMove(Player player, Board board, int column) {
        if (board.dropPiece(column, player.getColor())) {
            System.out.println(player.getName() + " a placé une pièce dans la colonne " + column);
            board.displayGrid();
        } else {
            System.out.println("Colonne " + column + " est pleine. Essayez une autre colonne.");
        }
    }
}
