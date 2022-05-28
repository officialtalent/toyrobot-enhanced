package com.devhouseagency.toyrobot.command;

import com.devhouseagency.toyrobot.Robot;

public abstract class Command {
    private final String name;
    private String argument;

    public abstract boolean execute(Robot target);

    public Command(String name) {
        this.name = name;
        this.argument = "";
    }

    public Command(String name, String argument) {
        this(name);
        this.argument = argument;
    }

    public String getName() {
        return name;
    }

    public String getArgument() {
        return argument;
    }

    public static Command create(String instruction) {
        String[] args = instruction.trim().toLowerCase().split(" ", 2);

        switch (args[0]) {
            case "shutdown":
            case "off":
                return new ShutdownCommand();
            case "forward":
                return new ForwardCommand(args[1]);
            case "back":
                return new BackCommand(args[1]);
            case "help":
                return new HelpCommand();
            case "right":
                return new RightCommand();
            case "left":
                return new LeftCommand();
            case "sprint":
                return new SprintCommand(args[1]);
            case "replay":
                return new ReplayCommand(args.length > 1 ? args[2] : "");
            default:
                throw new IllegalArgumentException("Unsupported command " + instruction);
        }
    }
}
