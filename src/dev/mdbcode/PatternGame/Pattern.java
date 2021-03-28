/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.mdbcode.PatternGame;

/**
 *
 * @author mdbil
 */
public enum Pattern {
  DASH("/"),
  EX("X"),
  DOT("."),
  BANG("!"),
  POUND("#");
  
  public final String pattern;

    private Pattern(String pattern) {
        this.pattern = pattern;
    }
  
  @Override
    public String toString() {
      return pattern;
    }
}
