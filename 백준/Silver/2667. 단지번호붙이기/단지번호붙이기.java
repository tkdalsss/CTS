import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static int[][] map;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visited = new boolean[N][N];
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            String tmp = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = tmp.charAt(j) - '0';
            }
        }

        int cnt = 0; // 단지 개수
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 1 && !visited[i][j]) {
                    list.add(bfs(i, j));
                    cnt += 1;
                }
            }
        }

        Collections.sort(list);
        System.out.println(cnt);
        for (int i : list) {
            System.out.println(i);
        }
    }

    static int bfs(int i, int j) {
        int cnt = 1;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{i, j});
        visited[i][j] = true;

        while(!q.isEmpty()) {
            int[] tmp = q.poll();
            int x = tmp[0];
            int y = tmp[1];

            int[] dx = {-1, 1, 0, 0};
            int[] dy = {0, 0, -1, 1};

            for (int k = 0; k < 4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];

                if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                if (map[nx][ny] == 0 || visited[nx][ny]) continue;

                visited[nx][ny] = true;
                q.add(new int[]{nx, ny});
                cnt += 1;
            }
        }

        return cnt;
    }
}