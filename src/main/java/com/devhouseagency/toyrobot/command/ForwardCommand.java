package com.devhouseagency.toyrobot.command;

import com.devhouseagency.toyrobot.Robot;

public class ForwardCommand extends Command {
    public ForwardCommand(String argument) {
        super("forward", argument);
    }

    @Override
    public boolean execute(Robot target) {
        target.setShouldPrint(true);
        int nrSteps = Integer.parseInt(getArgument());

        if (target.updatePosition(nrSteps)) {
            target.setStatus("Moved forward by " + nrSteps + " steps.");
        } else {
            target.setStatus("Sorry, I cannot go outside my safe zone.");
        }

        return true;
    }
}
