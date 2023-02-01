package com.mars_rover;

import org.junit.jupiter.api.Test;

import java.awt.*;

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
        rover.move("f");
        assertThat(rover.getPosition()).isEqualTo(new Point(2, 1));
    }

    @Test
    void moveUp() {
        MarsRover rover = MarsRover.create(new Point(1, 1), "N");
        rover.move("f");
        assertThat(rover.getPosition()).isEqualTo(new Point(1, 2));
    }

    @Test
    void moveDown() {
        MarsRover rover = MarsRover.create(new Point(1, 1), "N");
        rover.move("b");
        assertThat(rover.getPosition()).isEqualTo(new Point(1, 0));
    }

    @Test
    void getDirection() {
        MarsRover rover = MarsRover.create(new Point(1, 1), "S");
        assertThat(rover.getDirection()).isEqualTo("S");
    }

    @Test
    void turnLeft() {
        MarsRover rover = MarsRover.create(new Point(1, 1), "S");
        rover.turn("l");
        assertThat(rover.getDirection()).isEqualTo("E");
    }
}