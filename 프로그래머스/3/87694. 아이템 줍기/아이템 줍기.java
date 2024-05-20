import java.util.*;

public class Solution {
  public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
    int answer = 0;
    // 맵이 50*50, 좌표가 1~50
    int[][] field = new int[102][102];
    int[][] visited = new int[102][102];

    for (int i = 0; i < 102; i++) {
      Arrays.fill(field[i], -1); // field 초기화
      Arrays.fill(visited[i], 1);
    }

    for (int[] rect : rectangle) {
      int x1 = rect[0] * 2;
      int y1 = rect[1] * 2;
      int x2 = rect[2] * 2;
      int y2 = rect[3] * 2;

      for (int i = x1; i < x2 + 1; i++) {
        for (int j = y1; j < y2 + 1; j++) {
          if (i > x1 && i < x2 && j > y1 && j < y2) {
            // 테두리 부분이 아니라 내부라면 0으로 채움
            field[i][j] = 0;
          } else if (field[i][j] != 0) {
            // 테두리라면
            field[i][j] = 1;
          }
        }
      }
    }

    int[] dx = { -1, 0, 1, 0 };
    int[] dy = { 0, 1, 0, -1 };

    Queue<int[]> q = new LinkedList<>();
    q.offer(new int[] { characterX * 2, characterY * 2 });

    while (!q.isEmpty()) {
      int[] tmp = q.poll();
      int x = tmp[0];
      int y = tmp[1];

      if (itemX * 2 == x && itemY * 2 == y) {
        answer = visited[x][y] / 2;
        break;
      }

      for (int i = 0; i < 4; i++) {
        int nx = x + dx[i];
        int ny = y + dy[i];

        if (field[nx][ny] == 1 && visited[nx][ny] == 1) {
          visited[nx][ny] = visited[x][y] + 1;
          q.offer(new int[] { nx, ny });
        }
      }
    }

    return answer;
  }
}