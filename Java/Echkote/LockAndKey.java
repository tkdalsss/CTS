
public class LockAndKey {
  public static int[][] rotateMatrixBy90Degree(int[][] a) {
    int n = a.length;
    int m = a[0].length;
    int[][] result = new int[n][m];

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        result[j][n - i - 1] = a[i][j]; // 반시계 방향으로 90도 회전
        // 회전
        // 시계 방향 회전 matrix[rows - j - 1][i]
        // 반시계 방향 회전 matrix[j][cols - i - 1]
        // 180도 회전 matrix[rows - j - 1][cols - i - 1]
      }
    }
    return result;
  }

  public static boolean check(int[][] newLock) {
    int lockLength = newLock.length / 3;

    for (int i = lockLength; i < lockLength * 2; i++) {
      for (int j = lockLength; j < lockLength * 2; j++) {
        if (newLock[i][j] != 1) {
          return false;
        }
      }
    }

    return true;
  }

  public boolean solution(int[][] key, int[][] lock) {
    int n = lock.length;
    int m = key.length;

    // 자물쇠의 크기를 기존의 3배로 변환
    int[][] newLock = new int[n * 3][m * 3];

    // 새로운 자물쇠의 중앙 부분에 기존 자물쇠 넣기
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        newLock[i + n][j + n] = lock[i][j];
      }
    }

    // 4가지 방향 확인
    for (int rotation = 0; rotation < 4; rotation++) {
      key = rotateMatrixBy90Degree(key); // 열쇠 회전
      for (int x = 0; x < n * 2; x++) {
        for (int y = 0; y < n * 2; y++) {
          // 자물쇠에 열쇠 끼워 넣기
          for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
              newLock[x + i][y + j] += key[i][j];
            }
          }
          // 새로운 자물쇠에 열쇠가 정확히 들어 맞는지 검사
          if (check(newLock))
            return true;
          // 자물쇠에 열쇠를 다시 빼기
          for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
              newLock[x + i][y + j] -= key[i][j];
            }
          }
        }
      }
    }

    return false;
  }
}
