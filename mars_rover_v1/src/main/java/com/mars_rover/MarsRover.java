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
//        if ((move == "f" && direction == "E") || (move == "b" && direction == "W"))
//            moveCheck(new Point(this.position.x + 1, this.position.y));
//        else if ((move == "f" && direction == "W") || (move == "b" && direction == "E"))
//            moveCheck(new Point(this.position.x - 1, this.position.y));
//        else if ((move == "f" && direction == "N") || (move == "b" && direction == "S"))
//            moveCheck(new Point(this.position.x, this.position.y + 1));
//        else if ((move == "b" && direction == "N") || (move == "f" && direction == "S"))
//            moveCheck(new Point(this.position.x, this.position.y - 1));
    }

    private Point getNewPosition(String move) {
        return move.chars().mapToObj(i -> {
                    int x = this.position.x, y = this.position.y;

                    if (i == 'f' && this.getDirection().equals("E") || i == 'b' && this.getDirection().equals("W"))
//                        (this.moveCheck(this.position)) ? x += 1 : x += 1;
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

    public void turn(String toTurn) {
        if ((this.direction == "S" && toTurn == "l") || (this.direction == "N" && toTurn == "r")) this.direction = "E";
        else if ((this.direction == "W" && toTurn == "l") || (this.direction == "E" && toTurn == "r"))
            this.direction = "S";
        else if ((this.direction == "N" && toTurn == "l") || (this.direction == "S" && toTurn == "r"))
            this.direction = "W";
        else if ((this.direction == "E" && toTurn == "l") || (this.direction == "W" && toTurn == "r"))
            this.direction = "N";
    }
}