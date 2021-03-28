/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.mdbcode.game;

import dev.mdbcode.PatternGame.PatternSquare;
import java.util.Collection;
import java.util.Stack;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 *
 * @author mdbil
 * @param <T>
 */
public interface Print <T> {
  void printBoard(Board<T> board);
  void printSolution(Board<T> board, Stack<T> matchingPatterns);
  
  static <T extends Board> Collection<String> getBoardRows(Board board) {
    final AtomicInteger index = new AtomicInteger(0);
    Collection<String> boardRows = IntStream.range(0, board.getMaxPositions())
        .mapToObj(positionId -> (PatternSquare)board.getPosition(positionId))
        .map(patternSquare -> patternSquare != null ? patternSquare.getPattern().toString(): " ")
        .collect(Collectors.groupingBy(row -> index.getAndIncrement() / board.getColumns(),
                  Collectors.joining(" | ", "| ", " |")))
        .values();
    return boardRows;
  }
  
  static String getRowSeparator(int columns) {
    int characters = (columns * 4) + 1;
    return Stream.generate(() -> "-")
                 .limit(characters)
                 .collect(StringBuilder::new, 
                          StringBuilder::append, 
                          StringBuilder::append).toString();
  }
}
