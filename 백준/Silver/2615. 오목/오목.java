import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] map = new int[21][21];
    static int[][][] visited = new int[21][21][4];

    // 고려할 방향 4가지 오른쪽, 대각선 아래, 아래, 대각선 위
    static int[] dx = {1, 1, 0, -1};
    static int[] dy = {0, 1, 1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 1; i <= 19; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 1; j <= 19; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(isFive());
    }
    static String isFive() {
        for (int j = 1; j <= 19; j++) {
            for (int i = 1; i <= 19; i++) {
                if (map[i][j] != 0) {
                    for (int d = 0; d < 4; d++) {
                        if (visited[i][j][d] == 0 && calc(i, j, d, map[i][j]) == 5) {
                            return map[i][j] + "\n" + i + " " + j + "\n";
                        }
                    }
                }
            }
        }

        return "0";
    }
    static int calc(int x, int y, int d, int color) {
        int nx = x + dx[d];
        int ny = y + dy[d];;

        if (map[nx][ny] == color) {
            return visited[nx][ny][d] = calc(nx, ny, d, color) + 1;
        }

        return 1;
    }
}