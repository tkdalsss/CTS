package CTS.Java.Echkote;

import java.util.*;

class Combination {

  private int n;
  private int r;
  private int[] now;
  private ArrayList<ArrayList<Position>> result;

  public Combination(int n, int r) {
    this.n = n;
    this.r = r;
    this.now = new int[r];
    this.result = new ArrayList<ArrayList<Position>>();
  }

  public ArrayList<ArrayList<Position>> getResult() {
    return result;
  }

  public void combination(ArrayList<Position> arr, int depth, int index, int target) {
    if (depth == r) {
      ArrayList<Position> temp = new ArrayList<>();
      for (int i = 0; i < now.length; i++) {
        temp.add(arr.get(now[i]));
      }
      result.add(temp);
      return;
    }
    if (target == n)
      return;
    now[index] = target;
    combination(arr, depth + 1, index + 1, target + 1);
    combination(arr, depth, index, target + 1);
  }
}

class Position {
  private int x;
  private int y;

  public Position(int x, int y) {
    this.x = x;
    this.y = y;
  }

  public int getX() {
    return this.x;
  }

  public int getY() {
    return this.y;
  }
}
