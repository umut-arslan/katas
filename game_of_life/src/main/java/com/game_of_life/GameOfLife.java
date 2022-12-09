package com.game_of_life;

import java.util.List;

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

    public int getCountOfAliveNeighbours(Cell cell) {
        return 0;
    }
}
