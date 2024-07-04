package com.connect4.controller;

import com.connect4.model.*;

import java.util.EnumSet;
import java.util.Scanner;

public class Game {
    private Board board;
    private Player[] players;
    private Player currentPlayer;

    public Game(Player p1, Player p2) {
        board = new Board();
        players = new Player[2];
        players[0] = p1;
        players[1] = p2;
        currentPlayer = players[0];
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

        try (Scanner scanner = new Scanner(System.in)) {
            while (!gameWon && !board.isBoardFull()) {
                System.out.println(currentPlayer.getName() + ", c'est votre tour. Choisissez une colonne (0-6):");
                int column = scanner.nextInt();

                if (board.dropPiece(column, currentPlayer.getColor())) {
                    board.displayGrid();

                    if (board.checkPuissance4(currentPlayer.getColor())) {
                        System.out.println(currentPlayer.getName() + " a gagné!");
                        gameWon = true;
                    } else {
                        switchPlayer();
                    }
                } else {
                    System.out.println("Colonne " + column + " est pleine. Essayez une autre colonne.");
                }
            }

            if (!gameWon) {
                System.out.println("Le plateau est plein. Match nul!");
            }
        }
    }

    public void switchPlayer() {
        currentPlayer = (currentPlayer == players[0]) ? players[1] : players[0];
    }

    private static Colors chooseColor(Scanner scanner, EnumSet<Colors> availableColors) {
        Colors chosenColor = null;

        while (chosenColor == null) {
            System.out.println("Choisissez une couleur parmi les suivantes : " + availableColors);
            String colorChoice = scanner.nextLine().toUpperCase();
            try {
                Colors color = Colors.valueOf(colorChoice);
                if (availableColors.contains(color)) {
                    chosenColor = color;
                    availableColors.remove(color);
                } else {
                    System.out.println("Couleur déjà choisie ou invalide. Veuillez en choisir une autre.");
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Couleur invalide. Veuillez choisir une couleur valide.");
            }
        }

        return chosenColor;
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            // Saisir les noms des joueurs
            System.out.println("Entrez le nom du Joueur 1 :");
            String player1Name = scanner.nextLine();
            System.out.println("Entrez le nom du Joueur 2 :");
            String player2Name = scanner.nextLine();

            // Choisir les couleurs des joueurs
            EnumSet<Colors> availableColors = EnumSet.allOf(Colors.class);
            Colors player1Color = chooseColor(scanner, availableColors);
            Colors player2Color = chooseColor(scanner, availableColors);

            // Créer les joueurs
            Player player1 = new Player(player1Name, player1Color);
            Player player2 = new Player(player2Name, player2Color);

            // Lancer le jeu
            Game game = new Game(player1, player2);
            game.startGame();
        }
    }
}
