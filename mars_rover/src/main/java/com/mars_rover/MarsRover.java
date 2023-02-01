package com.mars_rover;


import java.awt.*;

/**
 * Hello world!
 */
public class MarsRover {
    private Point position;
    private String direction;

    private MarsRover(Point position, String direction) {
        this.position = new Point(position);
        this.direction = direction;
    }

    public static MarsRover create(Point startingPoint, String direction) {
        return new MarsRover(startingPoint, direction);
    }

    public void move(String move) {
        if ((move == "f" && direction == "E") || (move == "b" && direction == "W")) position.x += 1;
        else if ((move == "f" && direction == "W") || (move == "b" && direction == "E")) position.x -= 1;
        else if ((move == "f" && direction == "N") || (move == "b" && direction == "S")) position.y += 1;
        else if ((move == "b" && direction == "N") || (move == "f" && direction == "S")) position.y -= 1;
    }

    public Point getPosition() {
        return position;
    }

    public String getDirection() {
        return direction;
    }
}
