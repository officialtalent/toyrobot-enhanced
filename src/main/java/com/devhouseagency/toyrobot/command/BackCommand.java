package com.devhouseagency.toyrobot.command;

import com.devhouseagency.toyrobot.Robot;

public class BackCommand extends Command {
    public BackCommand(String argument) {
        super("back", argument);
    }

    @Override
    public boolean execute(Robot target) {
        int nrSteps = Integer.parseInt(getArgument());

        if (target.updatePosition(-nrSteps)) {
            target.setStatus("Moved back by " + nrSteps + " steps.");
        } else {
            target.setStatus("Sorry, I cannot go outside my safe zone.");
        }

        return true;
    }
}
