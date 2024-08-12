import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] distance;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int width = Integer.parseInt(st.nextToken());
        int height = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(br.readLine());
        int answer = 0, guard = 0;

        distance = new int[N];

        for (int i = 0; i < N + 1; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            int direction = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());
            int tmp = 0;

            switch (direction) {
                case 1:
                    tmp = dist;
                    break;
                case 2:
                    tmp = 2 * width + height - dist;
                    break;
                case 3:
                    tmp = 2 * (width + height) - dist;
                    break;
                case 4:
                    tmp = width + dist;
                    break;
            }

            if (i < N) {
                distance[i] = tmp;
            } else {
                guard = tmp;
            }
        }

        for (int i = 0; i < N; i++) {
            int path1 = Math.abs(distance[i] - guard);
            int path2 = 2 * (width + height) - path1;
            answer += Math.min(path1, path2);
        }

        System.out.println(answer);
    }
}