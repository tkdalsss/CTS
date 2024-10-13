import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " " );
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int answer = 0;

        int[] walls = new int[M];
        st = new StringTokenizer(br.readLine(), " " );
        for (int i = 0; i < M; i++) {
            walls[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i < M - 1; i++) {
            // walls[i]
            int left = 0;
            int right = 0;

            // 왼쪽에서 제일 높은데
            for (int j = 0; j < i; j++) {
                left = Math.max(walls[j], left);
            }
            // 오른쪽에서 제일 높은데
            for (int j = i + 1; j < M; j++) {
                right = Math.max(walls[j], right);
            }

            if (walls[i] < left && walls[i] < right) answer += Math.min(left, right) - walls[i];
        }

        System.out.println(answer);
    }
}