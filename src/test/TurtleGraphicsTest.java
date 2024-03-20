package test;

import org.junit.Test;
import model.Turtle;
import model.Floor;
import service.TurtleGraphicsService;
import exception.TurtleGraphicsException;

import static org.junit.Assert.assertEquals;

public class TurtleGraphicsTest {

    @Test
    public void testMoveForward() throws TurtleGraphicsException {
        Turtle turtle = new Turtle(0, 0, 0);
        Floor floor = new Floor(10, 10);
        TurtleGraphicsService service = new TurtleGraphicsService(turtle, floor);

        service.executeCommands(new int[]{1});
        assertPosition(0, -1, turtle);
    }

    @Test
    public void testTurnRight() throws TurtleGraphicsException {
        Turtle turtle = new Turtle(0, 0, 0);
        Floor floor = new Floor(10, 10);
        TurtleGraphicsService service = new TurtleGraphicsService(turtle, floor);

        service.executeCommands(new int[]{2});
        assertDirection(90, turtle);
    }

    @Test
    public void testTurnLeft() throws TurtleGraphicsException {
        Turtle turtle = new Turtle(0, 0, 0);
        Floor floor = new Floor(10, 10);
        TurtleGraphicsService service = new TurtleGraphicsService(turtle, floor);

        service.executeCommands(new int[]{3});
        assertDirection(270, turtle);
    }

    private void assertDirection(int i, Turtle turtle) {
        assertEquals(i, turtle.getDirection());
    }

    @Test
    public void testMoveForwardEast() throws TurtleGraphicsException {
        Turtle turtle = new Turtle(0, 0, 90);
        Floor floor = new Floor(10, 10);
        TurtleGraphicsService service = new TurtleGraphicsService(turtle, floor);

        service.executeCommands(new int[]{1});
        assertPosition(1, 0, turtle);
    }

    @Test
    public void testMoveForwardSouth() throws TurtleGraphicsException {
        Turtle turtle = new Turtle(0, 0, 180);
        Floor floor = new Floor(10, 10);
        TurtleGraphicsService service = new TurtleGraphicsService(turtle, floor);

        service.executeCommands(new int[]{1});
        assertPosition(0, 1, turtle);
    }

    @Test
    public void testMoveForwardWest() throws TurtleGraphicsException {
        Turtle turtle = new Turtle(0, 0, 270);
        Floor floor = new Floor(10, 10);
        TurtleGraphicsService service = new TurtleGraphicsService(turtle, floor);

        service.executeCommands(new int[]{1});
        assertPosition(-1, 0, turtle);
    }

    @Test
    public void testMultipleCommands() throws TurtleGraphicsException {
        Turtle turtle = new Turtle(0, 0, 0);
        Floor floor = new Floor(10, 10);
        TurtleGraphicsService service = new TurtleGraphicsService(turtle, floor);

        service.executeCommands(new int[]{1, 2, 1, 3, 1, 1});
        assertPosition(1, -1, turtle);
    }

    @Test
    public void testOutOfBoundsPosition() throws TurtleGraphicsException {
        Turtle turtle = new Turtle(9, 9, 0);
        Floor floor = new Floor(10, 10);
        TurtleGraphicsService service = new TurtleGraphicsService(turtle, floor);

        service.executeCommands(new int[]{1});
        assertPosition(9, 9, turtle);
    }

    private void assertPosition(int i, int i1, Turtle turtle) {
        assertEquals(i, turtle.getPosition()[0]);
        assertEquals(i1, turtle.getPosition()[1]);
    }

    @Test
    public void testInvalidCommandSequence() {
        Turtle turtle = new Turtle(0, 0, 0);
        Floor floor = new Floor(10, 10);
        TurtleGraphicsService service = new TurtleGraphicsService(turtle, floor);

        boolean exceptionThrown = false;
        try {
            service.executeCommands(new int[]{1, 2, 3, 4});
        } catch (TurtleGraphicsException e) {
            exceptionThrown = true;
        }
        assert exceptionThrown;
    }

    @Test(expected = TurtleGraphicsException.class)
    public void testInvalidInitialDirection() throws TurtleGraphicsException {
        Turtle turtle = new Turtle(0, 0, 45);
        Floor floor = new Floor(10, 10);
        TurtleGraphicsService service = new TurtleGraphicsService(turtle, floor);

        int[] commands = {1};
        service.executeCommands(commands);
    }
}
