package com.devhouseagency.toyrobot.command;

import com.devhouseagency.toyrobot.Robot;

public class ReplayCommand extends Command {
    public ReplayCommand(String argument) {
        super("replay", argument);
    }

    public void handleCommand(Robot robot) {
        String[] args = getArgument().split(" ");
    }

    @Override
    public boolean execute(Robot target) {
        handleCommand(target);
        return true;
    }
}
