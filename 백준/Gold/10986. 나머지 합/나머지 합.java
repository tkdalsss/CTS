import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        long[] map = new long[N + 1]; // 누적합 배열
        long[] cnt = new long[M]; // M으로 나누었을 때 나머지 값 저장 배열
        long answer = 0;

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i <= N; i++) {
            map[i] = (map[i-1] + Integer.parseInt(st.nextToken())) % M;

            if (map[i] == 0) answer += 1;

            cnt[(int) map[i]] += 1;
        }

        for (int i = 0; i < M; i++) {
            // 나머지가 같은 인덱스에서 2개씩 뽑는 경우 더해주기 map[j] % M == map[i-1] % M
            if (cnt[i] > 1) answer += (cnt[i] * (cnt[i]-1)) / 2;
        }

        System.out.println(answer);
    }
}