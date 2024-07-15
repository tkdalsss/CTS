import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int k = Integer.parseInt(br.readLine());

        while (k-- > 0) {
            st = new StringTokenizer(br.readLine());
            if (st.nextToken().equals("1")) {
                // 남자일때
                male(N, Integer.parseInt(st.nextToken()), arr);
            } else {
                female(N, Integer.parseInt(st.nextToken()), arr);
            }
        }

        for (int i = 0; i < N; i++) {
            System.out.print(arr[i] + " ");
            if ((i+1) % 20 == 0) System.out.println();
        }
    }

    static void male(int N, int k, int[] arr) {
        for (int i = 1; i <= N / k; i++) {
            arr[i*k-1] = arr[i*k-1] == 0 ? 1 : 0;
        }
    }

    static void female(int N, int k, int[] arr) {
        arr[k-1] = arr[k-1] == 0 ? 1 : 0;
        for (int i = 1; i < N/2; i++) {
            if(k-i < 1 || k+i >= N + 1) break;
            if(arr[k-i-1] == arr[k+i-1]) {
                arr[k-i-1] = arr[k-i-1] == 0 ? 1 : 0;
                arr[k+i-1] = arr[k+i-1] == 0 ? 1 : 0;
            } else break;
        }
    }
}