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

}