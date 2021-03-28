/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.mdbcode.game;

import java.util.List;

/**
 *
 * @author mdbil
 * @param <T>
 */
public interface Board<T> {

  List<T> getAdjacentPositions(Integer positionId);
  T getAdjacentSquare(Integer currentPosition, Integer adjacentPosition);
  int getColumns();
  int getMaxPositions();
  T getPosition(Integer positionId);
  List<T> getPositions();
  int getRows();
  void setPosition(int positionId, T value);
  
}
