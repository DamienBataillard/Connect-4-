package com.connect4.controller;

import com.connect4.logic.GameLogic;
import com.connect4.model.*;
import com.connect4.ui.GameUI;


public class Game {
    private Board board;
    private Player[] players;
    private Player currentPlayer;
    private GameUI gameUI;
    private GameLogic gameLogic;

    public Game(Player p1, Player p2, GameUI gameUI) {
        board = new Board();
        players = new Player[2];
        players[0] = p1;
        players[1] = p2;
        currentPlayer = players[0];
        this.gameUI = gameUI;
        this.gameLogic = new GameLogic();
    }

    public Board getBoard() {
        return board;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public void startGame() {
        board.displayGrid();
        boolean gameWon = false;

        while (!gameWon && !board.isBoardFull()) {
            int column = gameUI.getColumnChoice(currentPlayer.getName());
            if (column == -1) {
                System.out.println("Restarting the game...");
                board.reinitializeGrid();
                currentPlayer = players[0];
                board.displayGrid();
                continue;
            }

            gameLogic.makeMove(currentPlayer, board, column);

            if (board.checkPuissance4(currentPlayer.getColor())) {
                System.out.println(currentPlayer.getName() + " wins!");
                gameWon = true;
            } else {
                switchPlayer();
            }
        }

        if (!gameWon) {
            System.out.println("The board is full. It's a draw!");
        }
    }

    public void switchPlayer() {
        currentPlayer = (currentPlayer == players[0]) ? players[1] : players[0];
    }
}
