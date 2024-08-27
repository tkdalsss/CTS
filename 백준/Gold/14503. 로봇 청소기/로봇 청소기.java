import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M, r, c, d;
    static int count = 1;
    static int[][] map;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        cleaning(r, c, d);
        System.out.println(count);
    }
    static void cleaning(int x, int y, int dir) {
        map[x][y] = -1;

        for (int i = 0; i < 4; i++) {
            dir = (dir + 3) % 4; // 반시계 방향 회전
            int nx = x + dx[dir];
            int ny = y + dy[dir];

            if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
                if (map[nx][ny] == 0) {
                    count += 1;
                    cleaning(nx, ny, dir);
                    return;
                }
            }
        }

        int d = (dir + 2) % 4; // 후진할 때는 방향을 유지해야 하므로 별도 변수
        int bx = x + dx[d];
        int by = y + dy[d];

        if (bx >= 0 && by >= 0 && bx < N && by < M && map[bx][by] != 1) {
            cleaning(bx, by, dir);
        }
    }
}