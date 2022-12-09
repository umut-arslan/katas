package com.game_of_life;

import java.util.List;
import java.util.stream.IntStream;

/**
 * Hello world!
 */
public class GameOfLife {
    final List<Cell> cellList;

    public GameOfLife(List<Cell> cellList) {
        this.cellList = cellList;
    }

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }

    public List<Cell> getCellList() {
        return cellList;
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
}
