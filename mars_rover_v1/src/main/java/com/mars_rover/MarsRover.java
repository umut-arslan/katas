package com.mars_rover;


import java.awt.*;
import java.util.*;
import java.util.List;

/**
 * Hello world!
 */
public class MarsRover {
    private Point position;
    private String direction;

    private List<Point> obstacles;

    private MarsRover(Point position, String direction) {
        this.position = new Point(position);
        this.direction = direction;
        this.obstacles = Collections.emptyList();
    }

    private MarsRover(Point position, String direction, List<Point> obstacles) {
        this.position = new Point(position);
        this.direction = direction;
        this.obstacles = obstacles;
    }

    public static MarsRover create(Point startingPoint, String direction) {
        return new MarsRover(startingPoint, direction);
    }

    public static MarsRover create(Point startingPoint, String direction, List<Point> obstacles) {
        return new MarsRover(startingPoint, direction, obstacles);
    }

    public boolean moveCheck(Point point) {
        return !obstacles.contains(point);
    }

    public MarsRover move(String move) {
        return MarsRover.create(new Point(getNewPosition(move)), this.direction, this.obstacles);
    }

    private Point getNewPosition(String move) {
        return move.chars().mapToObj(i -> {
                    int x = this.position.x, y = this.position.y;

                    if (i == 'f' && this.getDirection().equals("E") || i == 'b' && this.getDirection().equals("W"))
                        x += this.moveCheck(new Point(x+1,y)) ? 1 : 0;
                    else if (i == 'f' && this.getDirection().equals("W") || i == 'b' && this.getDirection().equals("E"))
                        x -= this.moveCheck(new Point(x-1,y)) ? 1 : 0;

                    else if (i == 'f' && this.getDirection().equals("N") || i == 'b' && this.getDirection().equals("S"))
                        y += this.moveCheck(new Point(x,y+1)) ? 1 : 0;

                    else if (i == 'f' && this.getDirection().equals("S") || i == 'b' && this.getDirection().equals("N"))
                        y -= this.moveCheck(new Point(x,y-1)) ? 1 : 0;

                    return new Point(x, y);
                })
                .reduce(new Point(0, 0), (p1, p2) -> new Point(p1.x + p2.x, p1.y + p2.y));
    }

    public Point getPosition() {
        return position;
    }

    public String getDirection() {
        return direction;
    }

    public MarsRover turn(String toTurn) {
        return MarsRover.create(this.position, this.getNewTurn(toTurn), this.obstacles);
    }

    public String getNewTurn(String toTurn) {
        return toTurn.chars().mapToObj(i -> {
            String direction = "";
            if ((this.direction == "S" && i == 'l') || (this.direction == "N" && i == 'r')) direction = "E";
            if ((this.direction == "W" && i == 'l') || (this.direction == "E" && i == 'r')) direction = "S";
            if ((this.direction == "N" && i == 'l') || (this.direction == "S" && i == 'r')) direction = "W";
            if ((this.direction == "E" && i == 'l') || (this.direction == "W" && i == 'r')) direction = "N";
            return direction;
        }).reduce(new String(""), (subtotal, direction) -> new String(direction));
    }
}