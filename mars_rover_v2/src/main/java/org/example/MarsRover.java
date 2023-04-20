package org.example;

import lombok.NonNull;
import lombok.Value;

@Value
public class MarsRover {
    Position position;
    Direction direction;

    public MarsRover execute(@NonNull final String command) {
        return command.equals("")
                ? this
                : execute(command.charAt(0)).execute(command.substring(1));
    }

    private MarsRover execute(final char subCommand) {
        return switch (subCommand) {
            case 'F' -> moveForward();
            case 'B' -> moveBackward();
            case 'R' -> rotateRight();
            case 'L' -> rotateLeft();
            default -> this;
        };
    }

    private MarsRover rotateLeft() {
        return new MarsRover(this.position, direction.turnLeft());
    }

    private MarsRover rotateRight() {
        return new MarsRover(this.position, direction.turnRight());
    }

    private MarsRover moveBackward() {
        return switch (this.direction) {
            case NORTH -> new MarsRover(position.down(), Direction.NORTH);
            case EAST -> new MarsRover(position.left(), Direction.EAST);
            case SOUTH -> new MarsRover(position.up(), Direction.SOUTH);
            case WEST -> new MarsRover(position.right(), Direction.WEST);
        };
    }

    private MarsRover moveForward() {
        return switch (this.direction) {
            case NORTH -> new MarsRover(position.up(), Direction.NORTH);
            case EAST -> new MarsRover(position.right(), Direction.EAST);
            case SOUTH -> new MarsRover(position.down(), Direction.SOUTH);
            case WEST -> new MarsRover(position.left(), Direction.WEST);
        };
    }
}