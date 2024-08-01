import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int orientalMelon = Integer.parseInt(br.readLine()); // 참외 개수
        int[] arr = new int[6];
        int maxWIdx = 0;
        int maxHIdx = 0;
        int maxW = 0;
        int maxH = 0;

        for (int i = 0; i < 6; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int d = Integer.parseInt(st.nextToken());
            arr[i] = Integer.parseInt(st.nextToken());

            if ((d == 1 || d == 2) && maxW < arr[i]) {
                // 동쪽 or 서쪽
                maxW = arr[i];
                maxWIdx = i;
            } else if ((d == 3 || d == 4) && maxH < arr[i]) {
                // 남쪽 or 북쪽
                maxH = arr[i];
                maxHIdx = i;
            }
        }

        int right, left, minW, minH;

        if (maxWIdx + 1 == 6) right = 0;
        else right = maxWIdx + 1;

        if (maxWIdx - 1 == -1) left = 5;
        else left = maxWIdx - 1;
        minW = Math.abs(arr[right] - arr[left]);

        if (maxHIdx + 1 == 6) right = 0;
        else right = maxHIdx + 1;

        if (maxHIdx - 1 == -1) left = 5;
        else left = maxHIdx - 1;
        minH = Math.abs(arr[right] - arr[left]);

        System.out.println(((maxW*maxH) - (minW*minH)) * orientalMelon);
    }
}