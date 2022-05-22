package com.devhouseagency.toyrobot;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Arrays;

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

    @Test
    void testOff() {
        InputStream mocked = new ByteArrayInputStream("HAL\noff\n".getBytes());
        System.setIn(mocked);
        Play.main(new String[] {});

        String[] actual = osc.toString().trim().split("\n");
        System.out.println(Arrays.toString(actual));
        String[] expected = {""};
        verifyOutput(actual, expected);
    }

    @Test
    void testInvalidCommand() {
        InputStream mocked = new ByteArrayInputStream("HAL\ninvalid\noff\n".getBytes());
        System.setIn(mocked);
        Play.main(new String[] {});

        String[] actual = osc.toString().trim().split("\n");
        String[] expected = {""};
        verifyOutput(actual, expected);
    }
}
