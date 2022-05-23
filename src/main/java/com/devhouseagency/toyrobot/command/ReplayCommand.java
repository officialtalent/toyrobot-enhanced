package com.devhouseagency.toyrobot.command;

import com.devhouseagency.toyrobot.Robot;

public class ReplayCommand extends Command {
    public ReplayCommand(String argument) {
        super("replay", argument);
    }

    public void handleCommand(String argument) {
        String[] args = argument.split(" ");

        if (args.length == 1) {
            System.out.println(argument);
        }
    }

    @Override
    public boolean execute(Robot target) {
        System.out.println(getArgument());
        return true;
    }
}
