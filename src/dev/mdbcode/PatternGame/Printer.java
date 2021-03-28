/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.mdbcode.PatternGame;

import dev.mdbcode.PatternGame.PatternSquare;
import dev.mdbcode.game.Print;
import dev.mdbcode.game.Board;
import java.util.Collection;
import java.util.Stack;
import java.util.function.Function;

/**
 *
 * @author mdbil
 * @param <T>
 */
public class Printer<T extends PatternSquare> implements Print<T> {
  
  @Override
  public void printBoard(Board<T> board)  {
    Collection<String> boardRows = Print.getBoardRows(board);
    String rowSeparator = Print.getRowSeparator(board.getColumns());
    System.out.println(rowSeparator);
    boardRows.stream().map((row) -> {
      System.out.println(row);
      return row;
    }).forEachOrdered(row -> System.out.println(rowSeparator)); 
  }

  @Override
  public void printSolution(Board<T> board, Stack<T> matchingPatterns) {
    Function<Integer, String> columnRowPositionCoverter = e -> "Position at column: " + 
                                                               ((e % board.getColumns()) + 1)  + 
                                                               " row: " + ((e / board.getColumns()) + 1);
    T p = matchingPatterns.firstElement();
    System.out.println("Consecutive Squares with Pattern \"" + 
                        p.getPattern()  + "\" " + matchingPatterns.size());
    matchingPatterns.stream()
                    .map(e -> columnRowPositionCoverter.apply(e.getId()))
                    .forEach(System.out::println);
  }
}