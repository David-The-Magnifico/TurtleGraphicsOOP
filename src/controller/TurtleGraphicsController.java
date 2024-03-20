package controller;

import exception.TurtleGraphicsException;
import service.TurtleGraphicsService;

import java.util.Scanner;

public class TurtleGraphicsController {
    private TurtleGraphicsService turtleGraphicsService;

    public TurtleGraphicsController(TurtleGraphicsService turtleGraphicsService) {
        this.turtleGraphicsService = turtleGraphicsService;
    }

    public void startTurtleGraphics() {
        System.out.println("Welcome to Turtle Graphics Simulation Game!");
        System.out.println("Please enter the commands for the turtle:");

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        try {
            int[] commands = parseCommands(input);
            TurtleGraphicsService turtleGraphicsService = new TurtleGraphicsService(commands);
            turtleGraphicsService.executeCommands(commands);
        } catch (IllegalArgumentException e) {
            System.err.println("Error executing commands: " + e.getMessage());
        } catch (TurtleGraphicsException e) {
            throw new RuntimeException(e);
        }
    }


    
