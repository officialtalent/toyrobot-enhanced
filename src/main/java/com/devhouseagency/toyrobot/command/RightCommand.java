package com.devhouseagency.toyrobot.command;

import com.devhouseagency.toyrobot.Direction;
import com.devhouseagency.toyrobot.Robot;

public class RightCommand extends Command {
    public RightCommand() {
        super("right");
    }

    @Override
    public boolean execute(Robot target) {
        Direction[] directions = Direction.values();

        target.increaseDirectionIndex();
        Direction current = directions[target.getDirectionIndex()];

        target.setCurrentDirection(current);
        target.setStatus("Turned right.");

        return true;
    }
}
