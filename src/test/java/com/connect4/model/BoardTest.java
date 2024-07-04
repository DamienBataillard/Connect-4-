package com.connect4.model;

import org.junit.Test;
import static org.junit.Assert.*;

public class BoardTest {

    @Test
    public void testDropPiece() {
        Board board = new Board();
        assertTrue(board.dropPiece(0, Colors.RED));
        assertFalse(board.isColumnFull(0));
    }

    @Test
    public void testIsColumnFull() {
        Board board = new Board();
        for (int i = 0; i < 6; i++) {
            board.dropPiece(0, Colors.RED);
        }
        assertTrue(board.isColumnFull(0));
    }

    @Test
    public void testCheckPuissance4() {
        Board board = new Board();
        for (int i = 0; i < 4; i++) {
            board.dropPiece(i, Colors.RED);
        }
        assertTrue(board.checkPuissance4(Colors.RED));
    }

    @Test
    public void testIsBoardFull() {
        Board board = new Board();
        for (int col = 0; col < 7; col++) {
            for (int row = 0; row < 6; row++) {
                board.dropPiece(col, Colors.RED);
            }
        }
        assertTrue(board.isBoardFull());
    }
}
