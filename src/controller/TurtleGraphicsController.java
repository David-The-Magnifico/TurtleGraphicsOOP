package controller;

import exception.TurtleGraphicsException;
import service.TurtleGraphicsService;

import java.util.Scanner;

public class TurtleGraphicsController {
    private TurtleGraphicsService turtleGraphicsService;

    public TurtleGraphicsController(TurtleGraphicsService turtleGraphicsService) {
        this.turtleGraphicsService = turtleGraphicsService;
    }

   
