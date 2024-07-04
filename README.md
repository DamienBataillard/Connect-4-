# Connect 4

This project is an implementation of the Connect 4 game in Java. Two players can play against each other, choose their names and colors before starting the game.

## Prerequisites

Before starting, make sure you have the following software installed on your machine:

- [Java JDK 8 or higher](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html)
- [Apache Maven](https://maven.apache.org/download.cgi)

## Installation

1. Clone the GitHub repository:

   ```sh
   git clone https://github.com/your-username/connect-4.git


2. Navigate to the project directory:

    ```sh
    cd connect-4

3. Compilation
    To compile the project, use Maven:

    ```sh 
    mvn clean compile

4. Execution
    To run the game, use the following command:

    ```sh
    mvn exec:java

5. Game Instructions
    You will be prompted to enter the names of the two players.
    Each player will choose a color from the available options.
    The game will start with the first player chosen randomly.
    Players will alternately enter the column number (0-6) in which they want to drop their piece.
    The game ends when a player aligns four pieces of the same color horizontally, vertically, or diagonally, or when the board is full (draw).

6. Example Execution
    Enter the name of Player 1:
    Sarah
    Enter the name of Player 2:
    Kenza
    Sarah, choose your color (RED, YELLOW, BLUE, GREEN, ORANGE, PURPLE, PINK, CYAN, MAGENTA, LIME, TEAL, BROWN, BLACK, WHITE):
    RED
    Kenza, choose your color (RED, YELLOW, BLUE, GREEN, ORANGE, PURPLE, PINK, CYAN, MAGENTA, LIME, TEAL, BROWN, BLACK, WHITE):
    BLUE

    . . . . . . .
    . . . . . . .
    . . . . . . .
    . . . . . . .
    . . . . . . .
    . . . . . . .

    Sarah, it's your turn. Choose a column (0-6):

7. Author

    BATAILLARD Damien
    ELMESTARI Karim
    DE MENIBUS Olivier
    BENKIRANE Kamilia
