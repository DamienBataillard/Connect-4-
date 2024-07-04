package com.connect4.model;

import org.junit.Test;
import static org.junit.Assert.*;

public class CellTest {

    @Test
    public void testCellInitialization() {
        Cell cell = new Cell(0, 0);
        assertTrue(cell.isEmpty());
        assertNull(cell.getColor());
    }

    @Test
    public void testSetColor() {
        Cell cell = new Cell(0, 0);
        cell.setColor(Colors.RED);
        assertFalse(cell.isEmpty());
        assertEquals(Colors.RED, cell.getColor());
    }
}
