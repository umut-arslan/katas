package com.mars_rover;


import java.awt.*;

/**
 * Hello world!
 *
 */
public class MarsRover
{
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
        if ((move == "f" && direction == "S") || (move == "b" && direction == "B")) position.x+=1;
        else if ((move == "f" && direction == "W") || (move == "b" && direction == "S")) position.x-=1;
        else if ((move == "f" && direction == "N") || (move == "b" && direction == "E")) position.y+=1;
        else if ((move == "b" && direction == "N") || (move == "f" && direction == "E")) position.y-=1;
    }
    public Point getPosition() {
        return position;
    }
}
