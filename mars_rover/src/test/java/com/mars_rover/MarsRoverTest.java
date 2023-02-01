package com.mars_rover;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class MarsRoverTest{

    @Test
    void testTest() {
        assertThat(MarsRover.test()).isEqualTo("hello");
    }

}