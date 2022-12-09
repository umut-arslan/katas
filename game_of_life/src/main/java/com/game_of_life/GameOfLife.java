package com.game_of_life;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Hello world!
 */
public class GameOfLife {
    final List<Cell> listOfAliveCells;

    public GameOfLife(List<Cell> cellList) {
        this.listOfAliveCells = cellList;
    }

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }

    public List<Cell> getListOfAliveCells() {
        return listOfAliveCells;
    }

    public List<Cell> getNeighbours(Cell cell) {
        return List.of(
                new Cell(cell.x()-1, cell.y()-1),
                new Cell(cell.x()-1, cell.y()),
                new Cell(cell.x()-1, cell.y()+1),
                new Cell(cell.x(), cell.y()+1),
                new Cell(cell.x(), cell.y()-1),
                new Cell(cell.x()+1, cell.y()-1),
                new Cell(cell.x()+1, cell.y()),
                new Cell(cell.x()+1, cell.y()+1)
        );
    }

    public boolean isAlive(Cell cell) {
        return listOfAliveCells.contains(cell);
    }

    public long getCountOfAliveNeighbours(Cell cell) {
        return getNeighbours(cell).stream().filter(this::isAlive).count();
    }

    public List<Cell> getSurvivingGeneration() {
        return listOfAliveCells.stream()
          .filter(i -> getCountOfAliveNeighbours(i) <= 3 && getCountOfAliveNeighbours(i) >= 2).toList();
    }

    public boolean isDead(Cell cell) {
        return !isAlive(cell);
    }

    public List<Cell> getBirths() {
        return listOfAliveCells.stream()
                .map(this::getNeighbours)
                .flatMap(List::stream)
                .distinct()
                .filter(this::isDead)
                .filter(cell -> getCountOfAliveNeighbours(cell)==3)
                .toList();
    }

    public List<Cell> getNextGeneration() {
        return Stream.concat(getSurvivingGeneration().stream(), getBirths().stream()).toList();
    }
}
