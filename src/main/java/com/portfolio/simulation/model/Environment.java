package com.portfolio.simulation.model;

public class Environment {
    private final int width;
    private final int height;
    private final boolean[][] obstacles; // true if an obstacle exists at [x][y]

    public Environment(int width, int height) {
        this.width = width;
        this.height = height;
        this.obstacles = new boolean[width][height];

        // Add a few hardcoded obstacles to test our collision logic later
        addObstacle(3, 3);
        addObstacle(4, 5);
        addObstacle(7, 2);
    }

    public void addObstacle(int x, int y) {
        if (isValidCoordinate(x, y)) {
            obstacles[x][y] = true;
        }
    }

    // --- DEFENSIVE VALIDATION LOGIC ---

    /**
     * Checks if a target coordinate is within the boundaries of the grid.
     */
    public boolean isValidCoordinate(int x, int y) {
        return x >= 0 && x < width && y >= 0 && y < height;
    }

    /**
     * Checks if a target coordinate is blocked by an obstacle.
     */
    public boolean isObstacleAt(int x, int y) {
        if (!isValidCoordinate(x, y)) {
            return false; // Out of bounds is handled separately
        }
        return obstacles[x][y];
    }

    // Getters for the View layer
    public int getWidth() { return width; }
    public int getHeight() { return height; }
}