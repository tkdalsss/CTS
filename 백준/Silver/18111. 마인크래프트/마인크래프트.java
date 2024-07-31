import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M, B, MIN, MAX;
    static int[][] minecraft;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken()); // 인벤토리 블록 개수
        MIN = 256;
        MAX = 0;
        minecraft = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                minecraft[i][j] = Integer.parseInt(st.nextToken());
                MIN = Math.min(minecraft[i][j], MIN);
                MAX = Math.max(minecraft[i][j], MAX);
            }
        }

        System.out.println(flattening());
    }

    static String flattening() {
        int time = 999999999;
        int hVal = 0;

        for (int i = MIN; i <= MAX; i++) {
            int cnt = 0;
            int block = B;

            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if (i < minecraft[j][k]) {
                        cnt += ((minecraft[j][k] - i) * 2);
                        block += (minecraft[j][k] - i);
                    } else {
                        cnt += (i - minecraft[j][k]);
                        block -= (i - minecraft[j][k]);
                    }
                }
            }

            if (block < 0) break;

            if (time >= cnt) {
                time = cnt;
                hVal = i;
            }
        }

        return time + " " + hVal;
    }
}