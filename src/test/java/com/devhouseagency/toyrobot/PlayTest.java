package com.devhouseagency.toyrobot;

import org.junit.jupiter.api.Test;

import java.io.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlayTest {
    private void simulateGame(String simulatedUserInput, String expectedLastLine) {
        InputStream mockedInput = new ByteArrayInputStream(simulatedUserInput.getBytes());
        System.setIn(mockedInput);

        ByteArrayOutputStream osc = new ByteArrayOutputStream();
        System.setOut(new PrintStream(osc));

        Play.main(new String[]{});

        String[] linesOutput = osc.toString().trim().split("\n");

        StringBuilder output = new StringBuilder();
        for (String line : linesOutput) {
            output.append(line).append("\n");
        }

        assertEquals(expectedLastLine, output.toString().trim());
    }
}
