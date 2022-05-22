package com.devhouseagency.toyrobot.command;

import com.devhouseagency.toyrobot.Robot;

public class SprintCommand extends Command {
    public SprintCommand(String argument) {
        super("sprint", argument);
    }

    @Override
    public boolean execute(Robot target) {
        return false;
    }
}
