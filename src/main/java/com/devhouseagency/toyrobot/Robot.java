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
    private int directionIndex;
    private Direction currentDirection;

    private boolean shouldPrint = true;

    public Robot(String name) {
        this.name = name;
        this.status = "Ready.";
        this.position = CENTER;
        this.directionIndex = 0;
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
        } else if (currentDirection.equals(Direction.RIGHT)) {
            newX = newX + nrSteps;
        } else if (currentDirection.equals(Direction.LEFT)) {
            newX = newX - nrSteps;
        } else if (currentDirection.equals(Direction.DOWN)) {
            newY = newY - nrSteps;
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

    public int getDirectionIndex() {
        return directionIndex;
    }

    public void setDirectionIndex(int directionIndex) {
        this.directionIndex = directionIndex;
    }

    public void increaseDirectionIndex() {
        if (this.getDirectionIndex() < 3)
            this.directionIndex++;
        else
            setDirectionIndex(0);
    }

    public void decreaseIndexDirection() {
        if (this.getDirectionIndex() > 0)
            this.directionIndex--;
        else
            setDirectionIndex(3);
    }

    public Direction getCurrentDirection() {
        return currentDirection;
    }

    public void setCurrentDirection(Direction currentDirection) {
        this.currentDirection = currentDirection;
    }

    public void storeHistory(History history) {

    }

    public void setShouldPrint(boolean shouldPrint) {
        this.shouldPrint = shouldPrint;
    }

    @Override
    public String toString() {
        return shouldPrint ? "["+position.getX()+","+position.getY()+"] " +
                name + "> " + status : status;
    }
}
