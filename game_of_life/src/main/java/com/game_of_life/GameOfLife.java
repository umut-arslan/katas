package com.game_of_life;

import java.util.List;
import java.util.stream.Collectors;

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

    public List<Cell> getBirths() {
        return null;
    }
}
