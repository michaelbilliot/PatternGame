/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.mdbcode.game;

/**
 *
 * @author mdbil
 */
public interface Game {
  Board getBoard();
  void execute();
}
