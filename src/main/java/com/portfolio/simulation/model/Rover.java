package com.portfolio.simulation.model;

public class Rover {
    private int x;
    private int y;
    private Direction facing;

    // Constructor: This sets the rover's initial drop point
    public Rover(int startX, int startY, Direction startFacing) {
        this.x = startX;
        this.y = startY;
        this.facing = startFacing;
    }

    // Getters so the graphical View can read where the rover is
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Direction getFacing() {
        return facing;
    }

    // --- MOVEMENT LOGIC ---

    public void turnLeft() {
        // A clean, modern switch statement to rotate 90 degrees counter-clockwise
        switch (facing) {
            case NORTH -> facing = Direction.WEST;
            case WEST -> facing = Direction.SOUTH;
            case SOUTH -> facing = Direction.EAST;
            case EAST -> facing = Direction.NORTH;
        }
    }

    public void turnRight() {
        // Rotate 90 degrees clockwise
        switch (facing) {
            case NORTH -> facing = Direction.EAST;
            case EAST -> facing = Direction.SOUTH;
            case SOUTH -> facing = Direction.WEST;
            case WEST -> facing = Direction.NORTH;
        }
    }

    public void moveForward() {
        // Important: In computer graphics (JavaFX), the origin (0,0) is the TOP-LEFT corner.
        // This means moving North DECREASES your Y coordinate, and moving South INCREASES it.
        switch (facing) {
            case NORTH -> y--;
            case SOUTH -> y++;
            case EAST -> x++;
            case WEST -> x--;
        }
    }
}