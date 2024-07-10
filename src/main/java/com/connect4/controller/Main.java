package com.connect4.controller;

import com.connect4.model.Colors;
import com.connect4.model.Player;
import com.connect4.ui.GameUI;

import java.util.EnumSet;

public class Main {
    public static void main(String[] args) {
        GameUI gameUI = new GameUI();
        EnumSet<Colors> availableColors = EnumSet.allOf(Colors.class);

        Player player1 = new Player("Player 1", Colors.RED);
        Player player2 = new Player("Player 2", Colors.YELLOW);

        boolean configUpdated = false;

        while (true) {
            gameUI.showMenu();
            int choice = gameUI.getMenuChoice();

            if (choice == 1) {
                // Start the game with current configuration
                Game game = new Game(player1, player2, gameUI);
                game.startGame();
            } else if (choice == 2) {
                // Configure the game
                String player1Name = gameUI.getPlayerName(1);
                String player2Name = gameUI.getPlayerName(2);

                player1 = new Player(player1Name, gameUI.chooseColor(player1Name, availableColors));
                player2 = new Player(player2Name, gameUI.chooseColor(player2Name, availableColors));

                configUpdated = true;
            } else if (choice == 3) {
                // Exit the program
                System.out.println("Exiting the game. Goodbye!");
                break;
            }

            if (configUpdated) {
                availableColors = EnumSet.allOf(Colors.class); // Reset available colors
                configUpdated = false;
            }
        }
    }
}
