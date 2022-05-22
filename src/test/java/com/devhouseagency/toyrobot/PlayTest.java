package com.devhouseagency.toyrobot;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlayTest {
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
}
