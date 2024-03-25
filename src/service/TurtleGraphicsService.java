package service;

import exception.TurtleGraphicsException;
import model.Floor;
import model.Turtle;

public class TurtleGraphicsService {
    private Turtle turtle;
    private Floor floor;

    public TurtleGraphicsService(Turtle turtle, Floor floor) {
        this.turtle = turtle;
        this.floor = floor;
    }

    public TurtleGraphicsService(int[] commands) {
        this.turtle = new Turtle(0, 0, 0);
        this.floor = new Floor(0, 0);
    }

    public void executeCommands(int[] commands) throws TurtleGraphicsException {
        for (int command : commands) {
            switch (command) {
                case 1:
                    moveForward();
                    break;
                case 2:
                    turnRight();
                    break;
                case 3:
                    turnLeft();
                    break;
                default:
                    throw new TurtleGraphicsException("Invalid command: " + command);
            }
        }
    }

    private void moveForward() {
        int[] currentPosition = turtle.getPosition();
        int direction = turtle.getDirection();

        int newX = currentPosition[0];
        int newY = currentPosition[1];

        switch (direction) {
            case 0:
                newY--;
                break;
            case 90:
                newX++;
                break;
            case 180:
                newY++;
                break;
            case 270:
                newX--;
                break;
        }

        turtle.setPosition(newX, newY);
        floor.markPosition(newX, newY);
    }

    private void turnRight() {
        int currentDirection = turtle.getDirection();
        int newDirection = (currentDirection + 90) % 360;
        turtle.setDirection(newDirection);
    }

    private void turnLeft() {
        int currentDirection = turtle.getDirection();
        int newDirection = (currentDirection + 270) % 360;
        turtle.setDirection(newDirection);
    }
}
