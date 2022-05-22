package com.devhouseagency.toyrobot.command;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CommandTest {
    @Test
    void createOff() {
        Command test = Command.create("off");
        assertEquals("off", test.getName());
        assertEquals("", test.getArgument());
    }

    @Test
    void createForward10() {
        Command test = Command.create("forward 10");
        assertEquals("forward", test.getName());
        assertEquals("10", test.getArgument());
    }

    @Test
    void createBack10() {
        Command test = Command.create("back 10");
        assertEquals("back", test.getName());
        assertEquals("10", test.getArgument());
    }

    @Test
    void createRight() {
        Command test = Command.create("right");
        assertEquals("right", test.getName());
    }

    @Test
    void createLeft() {
        Command test = Command.create("left");
        assertEquals("left", test.getName());
    }

    @Test
    void unsupportedCommand() {
        String exception = "";
        try {
            Command.create("eat");
        } catch (IllegalArgumentException e) {
            exception = e.getMessage().trim();
        } finally {
            assertEquals("Unsupported command eat", exception);
        }
    }
}
