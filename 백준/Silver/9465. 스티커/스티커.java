import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int[] answer = new int[T];

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            int[][] map = new int[2][N];
            int[][] dp = new int[2][N];

            for (int j = 0; j < 2; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                for (int k = 0; k < N; k++) {
                    map[j][k] = Integer.parseInt(st.nextToken());
                }
            }

            dp[0][0] = map[0][0];
            dp[1][0] = map[1][0];

            if (N > 1) {
                dp[0][1] = map[0][1] + dp[1][0];
                dp[1][1] = map[1][1] + dp[0][0];
            }

            for (int j = 2; j < N; j++) {
                dp[0][j] = map[0][j] + Math.max(dp[1][j-1], dp[1][j-2]);
                dp[1][j] = map[1][j] + Math.max(dp[0][j-1], dp[0][j-2]);
            }

            answer[i] = Math.max(dp[0][N-1], dp[1][N-1]);
        }

        for (int a : answer) {
            System.out.println(a);
        }
    }
}