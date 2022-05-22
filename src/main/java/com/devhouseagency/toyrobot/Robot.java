package com.devhouseagency.toyrobot;

import com.devhouseagency.toyrobot.command.Command;

public class Robot {
    /*
    * These are constraints of our robot. It cannot go beyond these
    * bounds.
    * */
    private final Position TOP_LEFT = new Position(-100, 200);
    private final Position BOTTOM_RIGHT = new Position(100, -200);

    /*
    * Initially our robot is placed at the center of the imaginary
    * world, new Position(0, 0).
    * */
    private final Position CENTER = new Position(0, 0);

    /*
    * Our robot must have a state that we manipulate, here we declare
    * state variables (fields) that we will use later to track our
    * robot instances.
    * */
    private final String name;
    private String status;

    private Position position;
    private Direction currentDirection;

    public Robot(String name) {
        this.name = name;
        this.status = "Ready.";
        this.position = CENTER;
        this.currentDirection = Direction.UP;
    }

    public boolean handleCommand(Command command) {
        return command.execute(this);
    }

    public boolean updatePosition(int nrSteps) {
        int newX = position.getX();
        int newY = position.getY();

        if (currentDirection.equals(Direction.UP)) {
            newY = newY + nrSteps;
        }

        Position newPosition = new Position(newX, newY);
        if (newPosition.isIn(TOP_LEFT, BOTTOM_RIGHT)) {
            position = newPosition;
            return true;
        }

        return false;
    }

    public String getName() {
        return name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Direction getCurrentDirection() {
        return currentDirection;
    }

    public void setCurrentDirection(Direction currentDirection) {
        this.currentDirection = currentDirection;
    }

    @Override
    public String toString() {
        return "["+position.getX()+","+position.getY()+"] " +
                name + "> " + status;
    }
}