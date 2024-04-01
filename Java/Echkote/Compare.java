import java.util.*;

class Point implements Comparable<Point> {
  public int x;
  public int y;

  public Point(int x, int y) {
    this.x = x;
    this.y = y;
  }

  public int getX() {
    return x;
  }

  public int getY() {
    return y;
  }

  @Override
  public int compareTo(Point other) {
    return Integer.compare(this.x, other.x);
  }
}

public class Compare {
  public static void main(String[] args) {
    Point[] pList = {
        new Point(3, 4), new Point(5, 3), new Point(4, 4)
    }; // -> arrays

    List<Point> list = Arrays.asList(pList);

    Collections.sort(list, new Comparator<Point>() {
      @Override
      public int compare(Point a, Point b) {
        return Integer.compare(a.getY(), b.getY());
      }
    });

    for (Point p : pList) {
      System.out.println("x = " + p.x + ", y = " + p.y);
    }
  }
}
