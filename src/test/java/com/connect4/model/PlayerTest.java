package com.connect4.model;

import org.junit.Test;
import static org.junit.Assert.*;

public class PlayerTest {

    @Test
    public void testMakeMove() {
        Board board = new Board();
        Player player = new Player("Test Player", Colors.RED);
        player.makeMove(board, 0);
        assertFalse(board.isColumnFull(0));
    }
}
