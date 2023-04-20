package org.example;

public enum Direction {
    NORTH,
    EAST,
    SOUTH,
    WEST;

    public Direction turnRight() {
        return switch (this) {
            case NORTH -> EAST;
            case EAST -> SOUTH;
            case SOUTH -> WEST;
            case WEST -> NORTH;
        };
    }

    public Direction turnLeft() {
        return turnRight().turnRight().turnRight();
    }
}
