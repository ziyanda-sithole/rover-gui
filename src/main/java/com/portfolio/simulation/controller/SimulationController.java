package com.portfolio.simulation.controller;

import javafx.scene.input.KeyEvent;

import com.portfolio.simulation.model.Direction;
import com.portfolio.simulation.model.Environment;
import com.portfolio.simulation.model.Rover;
import com.portfolio.simulation.view.SimulationView;

public class SimulationController {
    private final Environment environment;
    private final Rover rover;
    private final SimulationView view;

    public SimulationController(Environment environment, Rover rover, SimulationView view) {
        this.environment = environment;
        this.rover = rover;
        this.view = view;
    }

    /**
     * This method listens for keyboard events and updates the Model.
     */
    public void handleKeyPress(KeyEvent event) {
        switch (event.getCode()) {
            case LEFT -> rover.turnLeft();
            case RIGHT -> rover.turnRight();
            case UP -> attemptMoveForward();
            default -> {
                // Ignore any other keys
                return;
            }
        }

        // After the Model is updated, tell the View to redraw the screen
        view.drawBoard();
    }

    /**
     * The Traffic Cop logic: Checks if the path is clear BEFORE moving the rover.
     */
    private void attemptMoveForward() {
        int targetX = rover.getX();
        int targetY = rover.getY();

        // Calculate where the rover WANTS to go
        switch (rover.getFacing()) {
            case NORTH -> targetY--;
            case SOUTH -> targetY++;
            case EAST -> targetX++;
            case WEST -> targetX--;
        }

        // Validate the target coordinates against the Environment
        if (!environment.isValidCoordinate(targetX, targetY)) {
            System.out.println("Warning: Boundary reached. Cannot move.");
        } else if (environment.isObstacleAt(targetX, targetY)) {
            System.out.println("Warning: Obstacle detected at (" + targetX + ", " + targetY + "). Movement blocked.");
        } else {
            // Path is clear, execute the move
            rover.moveForward();
            System.out.println("Moved to (" + rover.getX() + ", " + rover.getY() + ")");
        }
    }
}