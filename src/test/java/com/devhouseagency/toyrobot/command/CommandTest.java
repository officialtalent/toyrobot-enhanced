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
