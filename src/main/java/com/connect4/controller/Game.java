package com.connect4.controller;

import com.connect4.logic.GameLogic;
import com.connect4.model.*;
import com.connect4.ui.GameUI;

import java.util.EnumSet;

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
        boolean continuePlaying = true;
        while (continuePlaying) {
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

            continuePlaying = gameUI.askToPlayAgain();
            if (continuePlaying) {
                board.reinitializeGrid();
                currentPlayer = players[0];
            }
        }
    }

    public void switchPlayer() {
        currentPlayer = (currentPlayer == players[0]) ? players[1] : players[0];
    }

    public static void main(String[] args) {
        GameUI gameUI = new GameUI();

        // Enter player names
        String player1Name = gameUI.getPlayerName(1);
        String player2Name = gameUI.getPlayerName(2);

        // Choose player colors
        EnumSet<Colors> availableColors = EnumSet.allOf(Colors.class);
        Colors player1Color = gameUI.chooseColor(player1Name, availableColors);
        Colors player2Color = gameUI.chooseColor(player2Name, availableColors);

        // Create players
        Player player1 = new Player(player1Name, player1Color);
        Player player2 = new Player(player2Name, player2Color);

        // Start the game
        Game game = new Game(player1, player2, gameUI);
        game.startGame();
    }
}
