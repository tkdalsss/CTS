import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] answer = new int[N];

        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            int distance = end - start;

            int cnt = 0;

            // 거리의 제곱근 구하기 25 -> 5 + 4 = 9
            int tmp = (int) Math.sqrt(distance);
            // 제곱근, 제곱근 +1 제곱 해서 더 가까운거에 count
            if (tmp * tmp == distance) {
                cnt = tmp * 2 - 1;
            } else if (tmp * tmp + tmp < distance) {
                cnt = tmp * 2 + 1;
            } else {
                cnt = tmp * 2;
            }

            answer[i] = cnt;
        }

        for (int a : answer) {
            System.out.println(a);
        }
    }
}