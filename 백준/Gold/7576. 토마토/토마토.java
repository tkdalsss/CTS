import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[][] tomatoMap;
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int days = 0;

        tomatoMap = new int[M][N];
        visited = new boolean[M][N];
        boolean flag = false;
        Queue<int[]> q = new LinkedList<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                int tmp = Integer.parseInt(st.nextToken());
                tomatoMap[i][j] = tmp;
                if (tmp == 0) flag = true;
                else if (tmp == 1) q.offer(new int[]{i, j});
            }
        }

        if(!flag) {
            System.out.println(0);
            return;
        }

        while(!q.isEmpty()) {
            int size = q.size();

            for (int j = 0; j < size; j++) {
                int[] cur = q.poll();
                int cx = cur[0];
                int cy = cur[1];

                for (int i = 0; i < 4; i++) {
                    int nx = cx + dx[i];
                    int ny = cy + dy[i];

                    if (nx >= 0 && ny >= 0 && nx < M && ny < N && tomatoMap[nx][ny] == 0) {
                        tomatoMap[nx][ny] = 1;
                        q.offer(new int[]{nx, ny});
                    }
                }
            }

            if (!q.isEmpty()) {
                days += 1;
            }
        }

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if(tomatoMap[i][j] == 0) {
                    System.out.println(-1);
                    return;
                }
            }
        }

        System.out.println(days);
    }
}