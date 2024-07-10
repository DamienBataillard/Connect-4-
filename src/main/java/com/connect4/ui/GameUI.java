package com.connect4.ui;

import com.connect4.model.Colors;

import java.util.EnumSet;
import java.util.Scanner;

public class GameUI {
    private Scanner scanner;

    public GameUI() {
        scanner = new Scanner(System.in);
    }

    public void showMenu() {
        System.out.println("1. Start Game");
        System.out.println("2. Configure Game");
        System.out.println("3. Exit");
    }

    public int getMenuChoice() {
        int choice = -1;
        while (choice < 1 || choice > 3) {
            System.out.print("Enter your choice: ");
            try {
                choice = Integer.parseInt(scanner.next());
                if (choice < 1 || choice > 3) {
                    System.out.println("Invalid choice. Please choose between 1 and 3.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number between 1 and 3.");
            }
        }
        return choice;
    }

    public String getPlayerName(int playerNumber) {
        System.out.println("Enter the name of Player " + playerNumber + ":");
        return scanner.next();
    }

    public Colors chooseColor(String playerName, EnumSet<Colors> availableColors) {
        Colors chosenColor = null;

        while (chosenColor == null) {
            System.out.println(playerName + ", choose a color from the following: " + availableColors);
            String colorChoice = scanner.next().toUpperCase();
            try {
                Colors color = Colors.valueOf(colorChoice);
                if (availableColors.contains(color)) {
                    chosenColor = color;
                    availableColors.remove(color);
                } else {
                    System.out.println("Color already chosen or invalid. Please choose another.");
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid color. Please choose a valid color.");
            }
        }

        return chosenColor;
    }

    public int getColumnChoice(String playerName) {
        int column = -1;
        while (column < 0 || column > 6) {
            System.out.println(playerName + ", it's your turn. Choose a column (0-6) or type RESTART to start a new game:");
            String input = scanner.next();
            if (input.equalsIgnoreCase("RESTART")) {
                return -1;
            }
            try {
                column = Integer.parseInt(input);
                if (column < 0 || column > 6) {
                    System.out.println("Invalid column. Please choose a column between 0 and 6.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number between 0 and 6.");
            }
        }
        return column;
    }
}
