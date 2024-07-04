package com.connect4.controller;

import com.connect4.model.Colors;
import com.connect4.model.Player;
import org.junit.Test;
import static org.junit.Assert.*;

public class GameTest {

    @Test
    public void testGameInitialization() {
        Player player1 = new Player("Sarah", Colors.RED);
        Player player2 = new Player("Kenza", Colors.YELLOW);
        Game game = new Game(player1, player2);

        assertNotNull(game);
        assertEquals("Sarah", player1.getName());
        assertEquals("Kenza", player2.getName());
    }

    @Test
    public void testStartGame() {
        Player player1 = new Player("Sarah", Colors.RED);
        Player player2 = new Player("Kenza", Colors.YELLOW);
        Game game = new Game(player1, player2);

        // Simulate a game where player1 wins by filling the first column
        for (int i = 0; i < 4; i++) {
            player1.makeMove(game.getBoard(), 0);
        }

        assertTrue(game.getBoard().checkPuissance4(Colors.RED));
    }

    @Test
    public void testSwitchPlayer() {
        Player player1 = new Player("Sarah", Colors.RED);
        Player player2 = new Player("Kenza", Colors.YELLOW);
        Game game = new Game(player1, player2);

        // Ensure that after one move the current player switches
        assertEquals(player1, game.getCurrentPlayer());
        game.getCurrentPlayer().makeMove(game.getBoard(), 0);
        game.switchPlayer();
        assertEquals(player2, game.getCurrentPlayer());
    }
}
