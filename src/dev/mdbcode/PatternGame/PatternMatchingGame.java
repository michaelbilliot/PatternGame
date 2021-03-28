/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.mdbcode.PatternGame;

import dev.mdbcode.game.Game;
import dev.mdbcode.game.Print;
import dev.mdbcode.game.Board;
import java.util.Comparator;
import java.util.List;
import java.util.Stack;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 *
 * @author mdbil
 * @param <T>
 */
public class PatternMatchingGame<T extends PatternSquare> implements Game {

  private Board<T> board;
  private final Stack<T> temp = new Stack<>();
  private final Print<T> printer = new Printer<>();
  
  Predicate<Integer> validBoardSpot = e -> e >= 0 && e < board.getMaxPositions();
  Predicate<Integer> squareExists = e -> board.getPosition(e) != null;
  Predicate<Integer> validAndExists = validBoardSpot.and(squareExists);
  Function<PatternSquare, Pattern> pattern = PatternSquare::getPattern;
  Comparator<PatternSquare> comparingPatterns = Comparator.comparing(pattern);
  Predicate<Integer> patternsMatch = e -> e == 0;
  
  public PatternMatchingGame(Board<T> board) {
    this.board = board;
  }
  
  @Override
  public Board<T> getBoard() {
    return board;
  }
  
  @Override
  public void execute() {
    Stack<T> matchingPatterns = getAdjacentPatternCount();
    printer.printBoard(board);
    printer.printSolution(board, matchingPatterns);
  }

  private Stack<T> getAdjacentPatternCount() {
    Stack<T> matchingPatterns = new Stack<>();
    for (int i = 0;  i < board.getMaxPositions(); i ++) {
      if (validAndExists.test(i)) {
        T value1 = board.getPosition(i);
        value1.setChecked(true);
        List<T> adjacentPositions = board.getAdjacentPositions(i);
          temp.push(value1);
          adjacentPositions.stream().forEachOrdered((square) -> {
            patternMatch(value1, square);
        });
      }
      if (temp.size() > matchingPatterns.size()) {
        matchingPatterns.clear();
        matchingPatterns.addAll(temp);   
      }
      temp.clear();
    }
    return matchingPatterns;
  } 

  private void patternMatch(T value1, T value2) {
    if (!value2.isChecked() && comparingPatterns.compare(value1, value2) == 0) {
      temp.push(value2);
      value2.setChecked(true);
      board.getAdjacentPositions(value2.getId())
           .forEach(adjacentSquare -> patternMatch(value2, adjacentSquare));
    } 
  }
}
