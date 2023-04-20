package org.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class MarsRoverTest {
    static Stream<Arguments> moveForward() {
        return Stream.of(
                Arguments.of(new Position(0, 1), Direction.NORTH),
                Arguments.of(new Position(1, 0), Direction.EAST),
                Arguments.of(new Position(0, -1), Direction.SOUTH),
                Arguments.of(new Position(-1, 0), Direction.WEST)

        );
    }

    static Stream<Arguments> moveBackwards() {
        return Stream.of(
                Arguments.of(new Position(0, -1), Direction.NORTH),
                Arguments.of(new Position(-1, 0), Direction.EAST),
                Arguments.of(new Position(0, 1), Direction.SOUTH),
                Arguments.of(new Position(1, 0), Direction.WEST)

        );
    }

    static Stream<Arguments> turnRight() {
        return Stream.of(
                Arguments.of(Direction.NORTH, Direction.EAST),
                Arguments.of(Direction.EAST, Direction.SOUTH),
                Arguments.of(Direction.SOUTH, Direction.WEST),
                Arguments.of(Direction.WEST, Direction.NORTH)
        );
    }

    static Stream<Arguments> turnLeft() {
        return Stream.of(
                Arguments.of(Direction.NORTH, Direction.WEST),
                Arguments.of(Direction.EAST, Direction.NORTH),
                Arguments.of(Direction.SOUTH, Direction.EAST),
                Arguments.of(Direction.WEST, Direction.SOUTH)
        );
    }

    @ParameterizedTest
    @MethodSource
    void moveForward(final Position expectedPosition, final Direction direction) {
        MarsRover rover = new MarsRover(new Position(0, 0), direction);
        MarsRover expectedRover = new MarsRover(expectedPosition, direction);

        MarsRover execute = rover.execute("F");

        assertThat(execute).isEqualTo(expectedRover);
    }

    @ParameterizedTest
    @MethodSource
    void moveBackwards(final Position expectedPosition, final Direction direction) {
        MarsRover rover = new MarsRover(new Position(0, 0), direction);
        MarsRover expectedRover = new MarsRover(expectedPosition, direction);

        MarsRover execute = rover.execute("B");

        assertThat(execute).isEqualTo(expectedRover);
    }

    @ParameterizedTest
    @MethodSource
    void turnRight(final Direction direction, final Direction turnDirection) {
        MarsRover rover = new MarsRover(new Position(0,0), direction);
        MarsRover expectedRover = new MarsRover(new Position(0,0), turnDirection);

        MarsRover execute = rover.execute("R");

        assertThat(execute).isEqualTo(expectedRover);
    }

    @ParameterizedTest
    @MethodSource
    void turnLeft(final Direction direction, final Direction turnDirection) {
        MarsRover rover = new MarsRover(new Position(0,0), direction);
        MarsRover expectedRover = new MarsRover(new Position(0,0), turnDirection);

        MarsRover execute = rover.execute("L");

        assertThat(execute).isEqualTo(expectedRover);
    }

    @Test
    void goForwardTwice() {
        MarsRover rover = new MarsRover(new Position(0,0), Direction.EAST);
        MarsRover expectedRover = new MarsRover(new Position(2,0), Direction.EAST);

        MarsRover execute = rover.execute("FF");

        assertThat(execute).isEqualTo(expectedRover);
    }

    @Test
    void goCrazy() {
        MarsRover rover = new MarsRover(new Position(0,0), Direction.EAST);
        MarsRover expectedRover = new MarsRover(new Position(2,4), Direction.NORTH);

        MarsRover execute = rover.execute("FFFBRRRFFFF");

        assertThat(execute).isEqualTo(expectedRover);
    }
}