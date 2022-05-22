package com.devhouseagency.toyrobot.command;

import com.devhouseagency.toyrobot.Robot;

public class SprintCommand extends Command {
    public SprintCommand(String argument) {
        super("sprint", argument);
    }

    @Override
    public boolean execute(Robot target) {
        StringBuilder extended = new StringBuilder();
        int nrSteps = Integer.parseInt(getArgument());

        for (int index = nrSteps; index > 0; index--) {
            Command forward = Command.create("forward " + index);
            forward.execute(target);

            if (index > 1) {
                extended.append(target.toString()).append("\n");
            } else {
                extended.append(target.toString());
            }
        }

        target.setShouldPrint(false);
        target.setStatus(extended.toString());

        return true;
    }
}
