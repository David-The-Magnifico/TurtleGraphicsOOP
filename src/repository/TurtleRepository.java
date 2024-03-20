package repository;

import model.Turtle;

public class TurtleRepository {
    private Turtle turtle;

    public void saveTurtle(Turtle turtle) {
        this.turtle = turtle;
        System.out.println("Turtle data saved successfully.");
    }

    public Turtle getTurtle() {
        if (turtle == null) {
            System.out.println("No turtle data found.");
            return null;
        }
        return turtle;
    }
}
