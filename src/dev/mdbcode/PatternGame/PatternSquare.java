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
public class PatternSquare {
  private final Pattern pattern;
  private final int id;
  private boolean checked = false;  
  
  public PatternSquare(int id, Pattern pattern) {
    this.id = id;
    this.pattern = pattern;
  }
  
  public void setChecked(boolean checked) {
    this.checked = checked;
  }
  
  public boolean isChecked() {
    return checked;
  }

  public Pattern getPattern() {
    return pattern;
  }
  
  public int getId() {
    return id;
  }
  
  @Override
  public String toString() {
    return "Square id = " + id + "  Pattern = " + pattern;
  }
}
