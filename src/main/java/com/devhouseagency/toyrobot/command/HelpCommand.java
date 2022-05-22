package com.devhouseagency.toyrobot.command;

import com.devhouseagency.toyrobot.Robot;

public class HelpCommand extends Command {
    public HelpCommand() {
        super("help");
    }

    @Override
    public boolean execute(Robot target) {
        target.setShouldPrint(true);
        return true;
    }
}
