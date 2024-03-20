
package util;

import exception.TurtleGraphicsException;
import model.Turtle;

public class CommandExecutor {

    public static void executeCommand(int command, Turtle turtle) throws TurtleGraphicsException {
        switch (command) {
            case 1: // Move forward
                moveForward(turtle);
                break;
            case 2: // Turn right
                turnRight(turtle);
                break;
            case 3: // Turn left
                turnLeft(turtle);
                break;
            default:
                throw new TurtleGraphicsException("Invalid command code: " + command);
        }
    }

    private static void moveForward(Turtle turtle) {
        int[] position = turtle.getPosition();
        int direction = turtle.getDirection();

        int x = position[0];
        int y = position[1];

        switch (direction) {
            case 0: // North
                turtle.setPosition(x, y - 1);
                break;
            case 90: // East
                turtle.setPosition(x + 1, y);
                break;
            case 180: // South
                turtle.setPosition(x, y + 1);
                break;
            case 270: // West
                turtle.setPosition(x - 1, y);
                break;
        }
    }

    private static void turnRight(Turtle turtle) {
        int direction = turtle.getDirection();
        direction = (direction + 90) % 360;
        turtle.setDirection(direction);
    }

    private static void turnLeft(Turtle turtle) {
        int direction = turtle.getDirection();
        direction = (direction + 270) % 360;
        turtle.setDirection(direction);
    }
}
