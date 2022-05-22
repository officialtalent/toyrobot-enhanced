package com.devhouseagency.toyrobot.command;

import com.devhouseagency.toyrobot.Robot;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BackCommandTest {
    @Test
    void backInbound() {
        Robot robot = new Robot("TALENT");
        Command command = Command.create("back 100");

        robot.handleCommand(command);
        assertEquals("[0,-100] TALENT> Moved back by 100 steps.", robot.toString());
    }

    @Test
    void backOutbound() {
        Robot robot = new Robot("TALENT");
        Command command = Command.create("back 250");

        robot.handleCommand(command);
        assertEquals("[0,0] TALENT> Sorry, I cannot go outside my safe zone.", robot.toString());
    }
}
