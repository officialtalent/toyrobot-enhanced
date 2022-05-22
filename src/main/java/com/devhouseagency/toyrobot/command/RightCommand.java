package com.devhouseagency.toyrobot.command;

import com.devhouseagency.toyrobot.Robot;

public class RightCommand extends Command {
    public RightCommand() {
        super("right");
    }

    @Override
    public boolean execute(Robot target) {
        target.setStatus("Turned right.");
        return true;
    }
}
