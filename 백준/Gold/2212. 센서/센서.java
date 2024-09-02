import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());
        int sum = 0;

        if (K >= N) {
            System.out.println(0);
            return;
        }
 
        int[] points = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            points[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(points);

        Integer[] diff = new Integer[N-1];
        for (int i = 0; i < N-1; i++) {
            diff[i] = points[i+1] - points[i];
        }

        Arrays.sort(diff, Collections.reverseOrder());

        for (int i = K-1; i < N-1; i++) {
            sum += diff[i];
        }
        System.out.println(sum);
    }
}