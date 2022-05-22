package com.devhouseagency.toyrobot.command;

import com.devhouseagency.toyrobot.Robot;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ForwardCommandTest {
    @Test
    void forwardInbound() {
        Robot robot = new Robot("TALENT");
        Command command = Command.create("forward 100");

        robot.handleCommand(command);
        assertEquals("[0,100] TALENT> Moved forward by 100 steps.", robot.toString());
    }

    @Test
    void forwardOutbound() {
        Robot robot = new Robot("TALENT");
        Command command = Command.create("forward 250");

        robot.handleCommand(command);
        assertEquals("[0,0] TALENT> Sorry, I cannot go outside my safe zone.", robot.toString());
    }
}
