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

    @Test
    void testOff() {
        String mockedInput = "HAL\noff\n";
        String expected = """
                What do you want to name your robot?
                Hello kiddo!
                [0,0] HAL> Ready.
                HAL> What must I do next?
                [0,0] HAL> bye""";

        simulateGame(mockedInput, expected);
    }

    @Test
    void testInvalidCommand() {
        String mockedInput = "HAL\ninvalid\noff\n";
        String expected = """
                What do you want to name your robot?
                Hello kiddo!
                [0,0] HAL> Ready.
                HAL> What must I do next?
                [0,0] HAL> Sorry, I did not understand 'invalid'.
                HAL> What must I do next?
                [0,0] HAL> bye""";

        simulateGame(mockedInput, expected);
    }

    @Test
    void testForwardCorrect() {
        String mockedInput = "HAL\nforward 10\noff\n";
        String expected = """
                What do you want to name your robot?
                Hello kiddo!
                [0,0] HAL> Ready.
                HAL> What must I do next?
                [0,10] HAL> Moved forward by 10 steps.
                HAL> What must I do next?
                [0,10] HAL> bye""";

        simulateGame(mockedInput, expected);
    }
}
