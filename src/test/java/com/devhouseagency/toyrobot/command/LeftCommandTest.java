package com.devhouseagency.toyrobot.command;

import com.devhouseagency.toyrobot.Robot;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LeftCommandTest {
    @Test
    void turnLeft() {
        Robot robot = new Robot("TALENT");
        Command command = Command.create("left");

        robot.handleCommand(command);
        assertEquals("[0,0] TALENT> Turned left.", robot.toString());
    }

    @Test
    void turnedRightForward10() {
        Robot robot = new Robot("TALENT");
        Command command1 = Command.create("left");

        robot.handleCommand(command1);
        assertEquals("[0,0] TALENT> Turned left.", robot.toString());

        Command command2 = Command.create("forward 10");
        robot.handleCommand(command2);
        assertEquals("[-10,0] TALENT> Moved forward by 10 steps.", robot.toString());
    }
}
