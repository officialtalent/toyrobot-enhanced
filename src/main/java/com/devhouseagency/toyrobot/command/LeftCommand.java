package com.devhouseagency.toyrobot.command;

import com.devhouseagency.toyrobot.Direction;
import com.devhouseagency.toyrobot.Robot;

public class LeftCommand extends Command{
    public LeftCommand() {
        super("left");
    }

    @Override
    public boolean execute(Robot target) {
        target.setShouldPrint(true);
        Direction[] directions = Direction.values();

        target.decreaseIndexDirection();
        Direction current = directions[target.getDirectionIndex()];

        target.setCurrentDirection(current);
        target.setStatus("Turned left.");
        return true;
    }
}
