package com.devhouseagency.toyrobot;

import com.devhouseagency.toyrobot.command.Command;

import java.util.Scanner;

public class Play {
    public static void main(String[] args) {
        Robot robot;
        String name = input("What do you want to name your robot?");
        robot = new Robot(name);

        System.out.println("Hello kiddo!");
        System.out.println(robot);

        Command command;
        boolean shouldContinue = true;

        do {
            String instruction = input(robot.getName()+"> What must I do next?");

            try {
                command = Command.create(instruction);
                shouldContinue = robot.handleCommand(command);
            } catch (IllegalArgumentException e) {
                robot.setStatus("Sorry, I did not understand '" + instruction + "'.");
            }

            System.out.println(robot);

        } while (shouldContinue);
    }

    private static String input(String prompt) {
        Scanner scanner = new Scanner(System.in);

        System.out.println(prompt);
        return scanner.nextLine();
    }
}
