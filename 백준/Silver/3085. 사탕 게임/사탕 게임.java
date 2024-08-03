import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N, max;
    static String[][] candies;

    public static void main(String[] args) throws IOException {
        // 행 또는 열 다 같은지 판단
        // 행 -> 해당 행 인덱스는 고정하고 열은 0 - 끝까지
        // 열 -> 해당 열 인덱스는 고정하고 행은 0 - 끝까지

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        max = 1;
        N = Integer.parseInt(br.readLine());
        candies = new String[N][N];

        for (int i = 0; i < N; i++) {
            candies[i] = br.readLine().split("");
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N-1; j++) {
                swap(i, j, i, j+1);
                search();
                swap(i, j+1, i, j);
            }
        }

        for (int i = 0; i < N-1; i++) {
            for (int j = 0; j < N; j++) {
                swap(i, j, i+1, j);
                search();
                swap(i+1, j, i, j);
            }
        }

        System.out.println(max);
    }

    static void swap(int x1, int y1, int x2, int y2) {
        String tmp = candies[x1][y1];
        candies[x1][y1] = candies[x2][y2];
        candies[x2][y2] = tmp;
    }

    static void search() {
        for (int i = 0; i < N; i++) {
            int cnt = 1;

            for (int j = 0; j < N-1; j++) {
                if (candies[i][j].equals(candies[i][j+1])) {
                    cnt += 1;
                    max = Math.max(cnt, max);
                } else {
                    cnt = 1;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            int cnt = 1;

            for (int j = 0; j < N - 1; j++) {
                if (candies[j][i].equals(candies[j+1][i])) {
                    cnt += 1;
                    max = Math.max(cnt, max);
                } else {
                    cnt = 1;
                }
            }
        }
    }
}