/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.mdbcode;

import dev.mdbcode.PatternGame.PatternMatchingBoard;
import dev.mdbcode.PatternGame.PatternMatchingGame;
import dev.mdbcode.PatternGame.PatternSquare;
import dev.mdbcode.PatternGame.Pattern;
import dev.mdbcode.game.Game;
import dev.mdbcode.game.Board;
import static junit.framework.Assert.*;
import org.junit.Test;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;


/**
 *
 * @author mdbil
 */
public class GameTest {
  
  private Game game;
  
  public GameTest() {
  }
  
  @BeforeClass
  public static void setUpClass() {
    
  }
  
  @AfterClass
  public static void tearDownClass() {
  }
  
  @Before
  public void setUp() {
    Board<PatternSquare> board = new PatternMatchingBoard<>(4);
    board.setPosition(0, new PatternSquare(0, Pattern.DOT));
    board.setPosition(1, new PatternSquare(1, Pattern.POUND));
    board.setPosition(2, new PatternSquare(2, Pattern.DOT));
    board.setPosition(3, new PatternSquare(3, Pattern.DOT));
    board.setPosition(4, new PatternSquare(4, Pattern.DOT));
    board.setPosition(5, new PatternSquare(5, Pattern.BANG));
    board.setPosition(6, new PatternSquare(6, Pattern.DOT));
    board.setPosition(7, new PatternSquare(7, Pattern.BANG));
    board.setPosition(8, new PatternSquare(8, Pattern.DOT));
    board.setPosition(9, new PatternSquare(9, Pattern.EX));
    board.setPosition(10, new PatternSquare(10, Pattern.DOT));
    board.setPosition(11, new PatternSquare(11, Pattern.POUND));
    board.setPosition(12, new PatternSquare(12, Pattern.DOT));
    board.setPosition(13, new PatternSquare(13, Pattern.DOT ));
    board.setPosition(14, new PatternSquare(14, Pattern.DOT));
    board.setPosition(15, new PatternSquare(15, Pattern.BANG));
    game = new PatternMatchingGame(board);
  }
  
  @After
  public void tearDown() {
  }
  
  @Test
  public void testRightAdjacentSquare() {
    Board<PatternSquare> board = game.getBoard();
    PatternSquare s = board.getAdjacentSquare(5, 6);
    assertEquals(board.getPosition(6), s);
  }
  
  @Test
  public void testLeftAdjacentSquare() {
    Board<PatternSquare> board = game.getBoard();
    PatternSquare s = board.getAdjacentSquare(5, 4);
    assertEquals(board.getPosition(4), s);
  }
  
  @Test
  public void testAboveAdjacentSquare() {
    Board<PatternSquare> board = game.getBoard();
    PatternSquare s = board.getAdjacentSquare(5, 1);
    assertEquals(board.getPosition(1), s);
  }
  
  @Test
  public void testBelowAdjacentSquare() {
    Board<PatternSquare> board = game.getBoard();
    PatternSquare s = board.getAdjacentSquare(5, 9);
    assertEquals(board.getPosition(9), s);
  }
}
