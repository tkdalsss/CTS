package CTS.Java;

import java.util.*;

class Node {
  private int time;
  private char direction;

  public Node(int time, char direction) {
    this.time = time;
    this.direction = direction;
  }

  public int getTime() {
    return this.time;
  }

  public char getDirection() {
    return this.direction;
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

public class Snake {
  public static int n, k, l;
  public static int[][] arr = new int[101][101]; // map info
  public static ArrayList<Node> info = new ArrayList<>(); // turn direction

  // 처음에는 오른쪽(동,남,서,북)
  public static int dx[] = { 0, 1, 0, -1 };
  public static int dy[] = { 1, 0, -1, 0 };

  public static int turn(int direction, char c) {
    if (c == 'L')
      direction = (direction == 0) ? 3 : direction - 1;
    else
      direction = (direction + 1) % 4;
    return direction;
  }

  public static int simulate() {
    int x = 1, y = 1; // 뱀 머리 위치
    arr[x][y] = 2; // 뱀은 2로
    int direction = 0; // 처음에는 동쪽
    int time = 0; // 시작한 뒤에 지난 '초'
    int index = 0; // 다음 회전 정보

    // 뱀 정보(꼬리가 앞쪽)
    Queue<Position> q = new LinkedList<>();
    q.offer(new Position(x, y));

    while (true) {
      // 4 방향
      int nx = x + dx[direction];
      int ny = y + dy[direction];

      if (1 <= nx && nx <= n && 1 <= ny && ny <= n && arr[nx][ny] != 2) {
        // 사과가 없으면 이동 후 꼬리 제거
        if (arr[nx][ny] == 0) {
          arr[nx][ny] = 2;
          q.offer(new Position(nx, ny));
          Position prev = q.poll();
          arr[prev.getX()][prev.getY()] = 0;
        }
        // 사과가 있으면 이동 후 꼬리 그대로
        if (arr[nx][ny] == 1) {
          arr[nx][ny] = 2;
          q.offer(new Position(nx, ny));
        }
      } else { // 벽이나 뱀의 몸통과 부딪혔으면
        time += 1;
        break;
      }

      // 다음 위치로 머리 이동
      x = nx;
      y = ny;
      time += 1;

      if (index < 1 && time == info.get(index).getTime()) {
        direction = turn(direction, info.get(index).getDirection());
        index += 1;
      }
    }
    return time;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    n = sc.nextInt();
    k = sc.nextInt();

    // map info
    for (int i = 0; i < k; i++) {
      int a = sc.nextInt();
      int b = sc.nextInt();
      arr[a][b] = 1;
    }

    // 방향 회전 정보 입력
    l = sc.nextInt();
    for (int i = 0; i < l; i++) {
      int x = sc.nextInt();
      char c = sc.next().charAt(0); // Left -> L
      info.add(new Node(x, c));
    }

    sc.close();
    System.out.println(simulate());
  }
}
