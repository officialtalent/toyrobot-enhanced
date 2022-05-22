package com.devhouseagency.toyrobot.command;

import com.devhouseagency.toyrobot.Robot;

public class ForwardCommand extends Command {
    public ForwardCommand(String argument) {
        super("forward", argument);
    }

    @Override
    public boolean execute(Robot target) {
        return true;
    }
}
