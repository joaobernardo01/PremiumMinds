package com.premiumminds.internship.screenlocking;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by aamado on 05-05-2022.
 */


class ScreenLockinPattern implements IScreenLockinPattern, Callable<Integer> {

 /**
   * Method to count patterns from firstPoint with the length
   * @param firstPoint initial matrix position
   * @param length the number of points used in pattern
   * @return number of patterns
  **/

  private ScreenLock screen;

  private int firstVertice, length;

  public void setFirstVertice(int v) {
    this.firstVertice = v;
  }

  public void setScreen(ScreenLock screen) {
    this.screen = screen;
  }

  public void setLength(int length) {
    this.length = length;
  }

  public Integer call() {
    return DFS(this.screen, this.firstVertice, this.length);
  }

  public int DFS(ScreenLock screen, int v, int length) {
    int sum = 0;
    if (length == 1) return 1;  

    screen.useVertice(v);


    for (int i = 1; i <= 9; i++) {
      if (!screen.getUsed(i) && screen.singleMove(v, i)) 
        sum += DFS(screen.copy(), i, length-1);
    }
    return sum;
  }

 
  public Future<Integer> countPatternsFrom(int firstPoint,int length) {
    this.setFirstVertice(firstPoint);
    this.setLength(length);
    this.setScreen(new ScreenLock());
    ExecutorService executor = Executors.newSingleThreadExecutor();
    return executor.submit(this);
  };
}
