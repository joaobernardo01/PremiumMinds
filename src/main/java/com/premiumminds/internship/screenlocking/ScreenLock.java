package com.premiumminds.internship.screenlocking;

class ScreenLock {
    private boolean[] used = new boolean[9];
  
    public ScreenLock() {
      for (int i = 0; i < 9; i++) {
        used[i] = false;
      }
    }
    
    public ScreenLock(boolean used[]) {
      this.used = used.clone();
    }
    
    public void useVertice(int i) {
      used[i-1] = true;
      /* if (!used[i-1]) {
        used[i-1] = false;
        return true;
      }
      else return false; */
    }
  
    public boolean getUsed(int vert) {
      return used[vert-1];
    }
  
    public boolean singleMove(int source, int dest) {
      if ((source == 1 && dest == 3) || (source == 3) && (dest == 1))
        return getUsed(2);
      if ((source == 1 && dest == 7) || (source == 7) && (dest == 1))
        return getUsed(4);
      if ((source == 1 && dest == 9) || (source == 9) && (dest == 1))
        return getUsed(5);
      if ((source == 2 && dest == 8) || (source == 8) && (dest == 2))
        return getUsed(5);
      if ((source == 3 && dest == 7) || (source == 7) && (dest == 3))
        return getUsed(5);
      if ((source == 3 && dest == 9) || (source == 9) && (dest == 3))
        return getUsed(6);
      if ((source == 4 && dest == 6) || (source == 6) && (dest == 4))
        return getUsed(5);
      if ((source == 7 && dest == 9) || (source == 9) && (dest == 7))
        return getUsed(8);
      
      else return true;
    }
  
    public ScreenLock copy() {
          return new ScreenLock(this.used);
      }
  }
  
  
  
  