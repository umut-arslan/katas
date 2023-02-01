package com.mars_rover;


import java.awt.*;

/**
 * Hello world!
 *
 */
public class MarsRover
{
    final Point startingPoint;
    final String direction;

    private MarsRover(Point startingPoint, String direction) {
        this.startingPoint = new Point(startingPoint);
        this.direction = direction;
    }
    public static MarsRover create(Point startingPoint, String direction) {
        return new MarsRover(startingPoint, direction);
    }
    public Point getPosition() {
        return startingPoint;
    }
}
