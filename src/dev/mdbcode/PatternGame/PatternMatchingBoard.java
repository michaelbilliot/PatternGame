/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.mdbcode.PatternGame;

import dev.mdbcode.game.Board;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *
 * @author mdbil
 * @param <T>
 */
public class PatternMatchingBoard<T> implements Board<T> {
  private final List<T> positions;
  private final int columns;
  private final int rows;
  
  public PatternMatchingBoard(int size) {
    columns = size;
    rows = size;
    positions = new ArrayList<>(columns * rows);
    for (int i = 0; i < columns * rows; i ++) {
      positions.add(i, null);
    }
  }
  
  @Override
  public int getMaxPositions() {
    return positions.size();
  }
  
  @Override
  public List<T> getPositions() {
    return Collections.unmodifiableList(positions);
  }
  
  @Override
  public void setPosition(int index, T value) {
    positions.set(index, value);
  }

  @Override
  public T getPosition(Integer e) {
    return positions.get(e);
  }

  @Override
  public int getColumns() {
    return columns;
  }

  @Override
  public int getRows() {
    return rows;
  }
  
  /**
   * Given a position on the board return the adjacent squares.
   * @param currentPosition current position on the board
   * @return List&lt;T&gt; of adjacent squares
   */
  @Override
  public List<T> getAdjacentPositions(Integer currentPosition) {
    //stream of the positions to the left, right, above, and below the currentPosition.
    return Stream.of(currentPosition - 1, currentPosition + 1, currentPosition - columns, currentPosition + columns)
                 .map(e -> getAdjacentSquare(currentPosition, e)) //map the position to a Square
                 .filter(e -> e != null) //remove any null values
                 .collect(Collectors.toList()); //collect the values to a list.
  }
  
  /**
   * Given a current position and an adjacent position, return the adjacent square.
   * @param currentPosition 
   * @param adjacentPosition
   * @return adjacent square
   */
  @Override
  public T getAdjacentSquare(Integer currentPosition, Integer adjacentPosition) {
    Predicate<Integer> validSquare = e -> e > 0 && e < getMaxPositions();
    BiPredicate<Integer, Integer> occupySameRow = (t,u) -> t / columns == u / columns;
    BiPredicate<Integer, Integer> occupySameColumn = (t,u) -> t % columns == u % columns;
    T adjacentSquare = null;
    if (validSquare.test(adjacentPosition)) {
      if (occupySameRow.test(currentPosition, adjacentPosition)) {
        adjacentSquare = getPosition(adjacentPosition);
      } else if (occupySameColumn.test(currentPosition, adjacentPosition)) {
        adjacentSquare = getPosition(adjacentPosition);
      }
    }
    return adjacentSquare;
  }
}
