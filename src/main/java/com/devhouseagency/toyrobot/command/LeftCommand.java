package com.devhouseagency.toyrobot.command;

import com.devhouseagency.toyrobot.Robot;

public class LeftCommand extends Command{
    public LeftCommand() {
        super("left");
    }

    @Override
    public boolean execute(Robot target) {
        target.setStatus("Turned left.");
        return true;
    }
}
