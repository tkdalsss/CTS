import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, K;
    static int[] distance = new int[100001];
    static boolean[] visited = new boolean[100001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        Arrays.fill(distance, Integer.MAX_VALUE);

        bfs(N);

        System.out.println(distance[K]);
    }
    static void bfs(int n) {
        Queue<Integer> q = new LinkedList<>();
        q.add(n);
        distance[n] = 0;
        visited[n] = true;

        int[] dx = {-1, 1, 0};

        while(!q.isEmpty()) {
            int current = q.poll();
            if (current == K) break;

            int next;

            for (int i = 0; i < 3; i++) {
                if (i == 2) next = current * 2;
                else next = current + dx[i];

                if (next < 0 || next > 100000) continue;
                if (visited[next]) continue;

                distance[next] = Math.min(distance[current] + 1, distance[next]);
                visited[next] = true;
                q.offer(next);
            }
        }
    }
}