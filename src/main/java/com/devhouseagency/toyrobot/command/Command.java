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

        return switch (args[0]) {
            case "shutdown", "off" -> new ShutdownCommand();
            case "forward" -> new ForwardCommand(args[1]);
            case "help" -> new HelpCommand();
            default -> throw new IllegalArgumentException("Unsupported command " + instruction);
        };
    }
}
