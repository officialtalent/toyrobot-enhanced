package com.devhouseagency.toyrobot.command;

import com.devhouseagency.toyrobot.Robot;

public class BackCommand extends Command {
    public BackCommand(String argument) {
        super("back", argument);
    }

    @Override
    public boolean execute(Robot target) {
        return true;
    }
}
