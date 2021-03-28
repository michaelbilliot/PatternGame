/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.mdbcode.PatternGame;

import dev.mdbcode.game.Game;
import dev.mdbcode.game.Board;
import java.util.Random;
import java.util.stream.IntStream;

/**
 *
 * @author mdbil
 */
public class PatternGame {
  
  private static Board<PatternSquare> createRandomBoard(int size) {
    Pattern[] patterns = Pattern.values();
    Board<PatternSquare> board = new PatternMatchingBoard<>(size);
    Random random = new Random();
    IntStream.range(0, board.getMaxPositions())
             .mapToObj(e -> new PatternSquare(e, patterns[random.nextInt(5)]))
             .forEach(e -> board.setPosition(e.getId(), e));
    return board;
  }
  
  /**
   * Creates a game where a pattern for each square on a game board is created. The game
   * then calculates the number of adjacent squares with the same pattern and prints the 
   * result.
   * @param args size of board (8 = 8x8 board, 4 = 4x4 board etc.)
   */
  public static void main(String[] args) {
    Board<PatternSquare> board = PatternGame.createRandomBoard(Integer.valueOf(args[0]));
    Game game =  new PatternMatchingGame<>(board);
    game.execute();
  }
}
