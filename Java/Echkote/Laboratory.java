package CTS.Java.Echkote;

import java.util.*;

public class Laboratory {

  public static int n, m, result = 0;
  public static int[][] arr = new int[8][8]; // 초기 맵 배열
  public static int[][] temp = new int[8][8]; // 벽 설치 뒤 배열

  // direction
  public static int[] dx = { -1, 0, 1, 0 };
  public static int[] dy = { 0, 1, 0, -1 };

  // DFS1 -> 바이러스가 사방으로 퍼지도록
  public static void virus(int x, int y) {
    for (int i = 0; i < 4; i++) {
      int nx = x + dx[i];
      int ny = y + dy[i];
      // 상,하,좌,우 중에 바이러스가 퍼질수 있는 경우
      if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
        if (temp[nx][ny] == 0) {
          temp[nx][ny] = 2;
          virus(nx, ny);
        }
      }
    }
  }

  // 현재 맵에서 안전영역 크기 계산 메서드
  public static int getScore() {
    int score = 0;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (temp[i][j] == 0) {
          score += 1;
        }
      }
    }
    return score;
  }

  // DFS2 -> 울타리 설치하고 매번 안전영역 크기 계산
  public static void dfs(int count) {
    // 울타리 3개 설치된 경우
    if (count == 3) {
      for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
          temp[i][j] = arr[i][j];
        }
      }
      // 각 바이러스의 위치에서 전파
      for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
          if (temp[i][j] == 2) {
            virus(i, j);
          }
        }
      }
    }
    // 빈 공간에 울타리 설치
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (arr[i][j] == 0) {
          arr[i][j] = 1;
          count += 1;
          dfs(count);
          arr[i][j] = 0;
          count -= 1;
        }
      }
    }
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    n = sc.nextInt();
    m = sc.nextInt();

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        arr[i][j] = sc.nextInt();
      }
    }

    dfs(0);
    System.out.println(result);

    sc.close();
  }

}
