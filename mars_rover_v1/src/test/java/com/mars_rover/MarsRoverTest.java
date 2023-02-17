package com.mars_rover;

import org.junit.jupiter.api.Test;

import java.awt.*;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

class MarsRoverTest {
    @Test
    void getCurrentPosition() {
        MarsRover rover = MarsRover.create(new Point(1, 1), "W");
        assertThat(rover.getPosition()).isEqualTo(new Point(1, 1));
    }

    @Test
    void moveForward() {
        MarsRover rover = MarsRover.create(new Point(1, 1), "E");
        MarsRover movedRover = rover.move("f");
        assertThat(movedRover.getPosition()).isEqualTo(new Point(2, 1));
    }

    @Test
    void moveUp() {
        MarsRover rover = MarsRover.create(new Point(1, 1), "N");
        MarsRover movedRover = rover.move("f");
        assertThat(movedRover.getPosition()).isEqualTo(new Point(1, 2));
    }

    @Test
    void moveDown() {
        MarsRover rover = MarsRover.create(new Point(1, 1), "N");
        MarsRover movedRover = rover.move("b");
        assertThat(movedRover.getPosition()).isEqualTo(new Point(1, 0));
    }

    @Test
    void getDirection() {
        MarsRover rover = MarsRover.create(new Point(1, 1), "S");
        assertThat(rover.getDirection()).isEqualTo("S");
    }

    @Test
    void turnLeft() {
        MarsRover rover = MarsRover.create(new Point(1, 1), "S");
        MarsRover newRover = rover.turn("l");
        assertThat(newRover.getDirection()).isEqualTo("E");
    }

    @Test
    void turnRight() {
        MarsRover rover = MarsRover.create(new Point(1, 1), "E");
        MarsRover newRover = rover.turn("r");
        assertThat(newRover.getDirection()).isEqualTo("S");
    }

    @Test
    void obstacleInfront() {
        List<Point> obstacles = Stream.of(new Point(1, 2)).toList();
        MarsRover rover = MarsRover.create(new Point(1, 1), "N", obstacles);
        MarsRover newRover = rover.move("f");
        assertThat(newRover.getPosition()).isEqualTo(new Point(1, 1));
    }

    @Test
    void nonObstacleInfront() {
        List<Point> obstacles = Stream.of(new Point(1, 3)).toList();
        MarsRover rover = MarsRover.create(new Point(1, 1), "N", obstacles);
        MarsRover movedRover = rover.move("f");
        assertThat(movedRover.getPosition()).isEqualTo(new Point(1, 2));
    }
}