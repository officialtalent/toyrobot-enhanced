package com.devhouseagency.toyrobot.command;

import com.devhouseagency.toyrobot.Robot;

public class ShutdownCommand extends Command {
    public ShutdownCommand() {
        super("off");
    }

    @Override
    public boolean execute(Robot target) {
        target.setShouldPrint(true);
        target.setStatus("bye");
        return false;
    }
}
