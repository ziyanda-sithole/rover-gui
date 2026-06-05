package com.portfolio.simulation.view;

import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

// Import our Model classes
import com.portfolio.simulation.model.Environment;
import com.portfolio.simulation.model.Rover;

public class SimulationView extends GridPane {
    private static final int TILE_SIZE = 40; // The pixel size of each grid square

    private final Environment environment;
    private final Rover rover;

    public SimulationView(Environment environment, Rover rover) {
        this.environment = environment;
        this.rover = rover;

        // Draw the initial state of the board
        drawBoard();
    }

    /**
     * Loops through every X and Y coordinate and draws a rectangle.
     * The color depends on what is located at that coordinate.
     */
    public void drawBoard() {
        // Clear the board before redrawing (important for when the rover moves later)
        this.getChildren().clear();

        for (int x = 0; x < environment.getWidth(); x++) {
            for (int y = 0; y < environment.getHeight(); y++) {

                Rectangle tile = new Rectangle(TILE_SIZE, TILE_SIZE);
                tile.setStroke(Color.DARKGRAY); // Adds a subtle grid border

                // Check what belongs in this tile
                if (rover.getX() == x && rover.getY() == y) {
                    tile.setFill(Color.LIMEGREEN); // The Rover is bright green
                } else if (environment.isObstacleAt(x, y)) {
                    tile.setFill(Color.STEELBLUE); // Lakes/Obstacles are blue
                } else {
                    tile.setFill(Color.WHITESMOKE); // Empty terrain
                }

                // Add the tile to the GridPane at column X and row Y
                this.add(tile, x, y);
            }
        }
    }
}