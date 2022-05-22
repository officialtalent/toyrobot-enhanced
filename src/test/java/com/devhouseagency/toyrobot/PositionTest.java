package com.devhouseagency.toyrobot;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PositionTest {
    @Test
    void getX() {
        Position position = new Position(1, 1);
        assertEquals(1, position.getX());
    }

    @Test
    void getY() {
        Position position = new Position(1, 5);
        assertEquals(5, position.getY());
    }

    @Test
    void isEqualPosition() {
        Position position = new Position(5, 7);
        assertTrue(position.equals(new Position(5, 7)));
        assertFalse(position.equals(new Position(9, 4)));
    }

    @Test
    void isInBounds() {
        Position topLeft = new Position(-100, 200);
        Position bottomRight = new Position(100, -200);

        Position p1 = new Position(100, 50);
        Position p2 = new Position(50, 250);

        assertTrue(p1.isIn(topLeft, bottomRight));
        assertFalse(p2.isIn(topLeft, bottomRight));
    }
}
