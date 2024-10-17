import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N, M, R, min;
    static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        
        min = Math.min(N, M) / 2;
        map = new int[N][M];
        
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        for (int i = 0; i < R; i++) {
            rotate();
        }
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                System.out.println(map[i][j]);
            }
        }
    }
    static void rotate() {
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        
        for (int i = 0; i < min; i++) {
            int x = i;
            int y = i;
            
            int tmp = map[x][y];
            
            int idx = 0; // 동서남북 체크
            while(idx < 4) {
                int nx = x + dx[idx];
                int ny = y + dy[idx];
                
                if (nx < N - i && ny < M - i && nx >= i && ny >= i) {
                    map[x][y] = map[nx][ny];
                    x = nx;
                    y = ny;
                } else idx += 1;
            }
            
            map[i+1][i] = tmp; // (0,0) -> (1,0)
        }
    }
}