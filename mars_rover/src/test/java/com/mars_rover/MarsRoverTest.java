package com.mars_rover;

import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.assertj.core.api.Assertions.*;

class MarsRoverTest{
    @Test
    void getCurrentPosition() {
        MarsRover rover = MarsRover.create(new Point(1, 1), "W");
        assertThat(rover.getPosition()).isEqualTo(new Point(1,1));
    }

    @Test
    void moveForward() {
        MarsRover rover = MarsRover.create(new Point(1, 1), "S");
        rover.move("f");
        assertThat(rover.getPosition()).isEqualTo(new Point(2,1));
    }

    @Test
    void moveBackwards() {
        MarsRover rover = MarsRover.create(new Point(1, 1), "S");
        rover.move("b");
        assertThat(rover.getPosition()).isEqualTo(new Point(0,1));
    }
}