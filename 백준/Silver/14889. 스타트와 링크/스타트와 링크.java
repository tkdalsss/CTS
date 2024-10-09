import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] stats;
    static boolean[] visit; // -> visit 배열 추가
    static int MIN = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        visit = new boolean[N];
        stats = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                stats[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        matching(0, 0);
        System.out.println(MIN);
    }
    static void matching(int idx, int depth) {
        if (depth >= N/2) {
            calculate();
            return;
        }

        for (int i = idx; i < N; i++) {
            if(!visit[i]) {
                visit[i] = true;
                matching(i + 1, depth + 1);
                visit[i] = false;
            }
        }
    }
    static void calculate() {
        int start_score = 0;
        int link_score = 0;

        for (int i = 0; i < N - 1; i++) {
            for (int j = i; j < N; j++) {
                if (visit[i] && visit[j]) {
                    start_score += stats[i][j] + stats[j][i];
                } else if (visit[i] == false && visit[j] == false) {
                    link_score += stats[i][j] + stats[j][i];
                }
            }
        }

        MIN = Math.min(MIN, Math.abs(start_score - link_score));
    }
}