package CTS.Java.Plus;

import java.util.*;

public class GameMapShortestPath {

  static int n;
  static int m;
  static int[][] visited;

  public int solution(int[][] maps) {
    n = maps.length;
    m = maps[0].length;
    int answer = 0;

    visited = new int[n][m];
    visited[0][0] = 1;

    bfs(maps);
    answer = visited[n - 1][m - 1];

    if (answer == 0)
      return -1;

    return answer;
  }

  static void bfs(int[][] maps) {
    Queue<int[]> q = new LinkedList<>();
    q.offer(new int[] { 0, 0 }); // start point input

    int[] dx = { -1, 0, 1, 0 };
    int[] dy = { 0, 1, 0, -1 };

    while (!q.isEmpty()) {
      int[] tmp = q.poll();
      int x = tmp[0];
      int y = tmp[1];

      for (int i = 0; i < 4; i++) {
        int nx = x + dx[i];
        int ny = y + dy[i];

        if (nx < 0 || nx > n - 1 || ny < 0 || ny > m - 1)
          continue; // index over

        if (visited[nx][ny] == 0 && maps[nx][ny] == 1) {
          visited[nx][ny] = visited[x][y] + 1;
          q.offer(new int[] { nx, ny });
        }
      }
    }
  }
}
