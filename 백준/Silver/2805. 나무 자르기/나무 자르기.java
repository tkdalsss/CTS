import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] trees = new int[n];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            trees[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(trees);

        int left = 0;
        int right = trees[trees.length-1];

        while (left < right) {
            int mid = (left + right) / 2;
            long tmp = 0;

            for (int t : trees) {
                tmp += Math.max(t - mid, 0);
            }

            if (tmp < k) right = mid;
            else left = mid + 1;
        }

        System.out.println(left - 1);
    }
}