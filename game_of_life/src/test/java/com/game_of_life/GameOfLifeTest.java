package com.game_of_life;


import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

//   1. Any live cell with fewer than two live neighbours dies, as if caused by underpopulation.
//   2. Any live cell with more than three live neighbours dies, as if by overcrowding.
//   3. Any live cell with two or three live neighbours lives on to the next generation.
//   4. Any dead cell with exactly three live neighbours becomes a live cell.

class GameOfLifeTest {
  @Test
  void returnListOfAliveCells() {
    List<Cell> cellList = List.of(new Cell(0, 0));
    GameOfLife gol = new GameOfLife(cellList);

    assertEquals(cellList, gol.getListOfAliveCells());
  }

  @Test
  void getNeighbours() {
    List<Cell> cellNeighbours = List.of(
                    new Cell(1-1, 1-1),
                    new Cell(1-1, 1),
                    new Cell(1-1, 1+1),
                    new Cell(1, 1+1),
                    new Cell(1, 1-1),
                    new Cell(1+1, 1-1),
                    new Cell(1+1, 1),
                    new Cell(1+1, 1+1)
    );
    GameOfLife gol = new GameOfLife(List.of(new Cell(1, 1)));


    assertEquals(cellNeighbours, gol.getNeighbours(new Cell(1,1)));
  }
  @Test
  void CheckIfCellIsAlive(){
    GameOfLife gol = new GameOfLife(List.of(new Cell(1, 1)));
    assertTrue(gol.isAlive(new Cell(1, 1)));
  }
  @Test
  void CheckIfCellIsDead(){
    GameOfLife gol = new GameOfLife(List.of(new Cell(1, 1)));

    assertFalse(gol.isAlive(new Cell(0, 0)));
  }

  @Test
  void getCountOfLivingNeighbours(){
    List<Cell> listOfLivingCells = List.of(new Cell(0, 0),new Cell(1, 1));
    GameOfLife gol = new GameOfLife(listOfLivingCells);

    assertEquals(1, gol.getCountOfAliveNeighbours(new Cell(1,1)));
  }

  @Test
  void getSurvivingGeneration() {
    List<Cell> listOfLivingCells = List.of(new Cell(0, 0), new Cell(1, 0) ,new Cell(1, 1));
    GameOfLife gol = new GameOfLife(listOfLivingCells);

    assertEquals(listOfLivingCells, gol.getSurvivingGeneration());
  }
}