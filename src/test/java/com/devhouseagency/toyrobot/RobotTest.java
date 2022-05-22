package com.devhouseagency.toyrobot;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RobotTest {
    private final PrintStream standardOut = System.out;
    private final InputStream standardIn  = System.in;
    private final ByteArrayOutputStream osc = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(osc));
    }

    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
        System.setIn(standardIn);
    }

    private void verifyOutput(String[] actual, String[] expected) {
        for (int i = actual.length - 1, j = expected.length - 1; j > 0; i--, j--) {
            assertEquals(expected[j], actual[i]);
        }
    }

    @Test
    void getRobotName() {
        Robot robot = new Robot("TALENT");
        assertEquals("TALENT", robot.getName());
    }

    @Test
    void getRobotStatus() {
        Robot robot = new Robot("TALENT");
        assertEquals("Ready.", robot.getStatus());
    }

    @Test
    void getUpdatedStatus() {
        Robot robot = new Robot("TALENT");
        robot.setStatus("I was updated.");
        assertEquals("I was updated.", robot.getStatus());
    }

    @Test
    void getRobotPosition() {
        Robot robot = new Robot("TALENT");
        assertEquals(new Position(0, 0), robot.getPosition());
    }

    @Test
    void getRobotCurrentDirection() {
        Robot robot = new Robot("TALENT");
        assertEquals(Direction.UP, robot.getCurrentDirection());
    }

    @Test
    void statusOutput() {
        Robot robot = new Robot("TALENT");
        String output = robot.toString();
        assertEquals("[0,0] TALENT> Ready.", output);
    }
}
