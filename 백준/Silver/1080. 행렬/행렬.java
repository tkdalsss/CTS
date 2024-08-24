import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[][] inputMap;
    static int[][] resultMap;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        inputMap = new int[N][M];
        resultMap = new int[N][M];
        int answer = 0;

        // original map
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                inputMap[i][j] = Integer.parseInt(String.valueOf(line.charAt(j)));
            }
        }

        // result map
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                resultMap[i][j] = Integer.parseInt(String.valueOf(line.charAt(j)));
            }
        }

        // 3*3 부분행렬보다 전체 맵 크기가 작은 경우
        if (N < 3 || M < 3) {
            if (isSameMatrix()) System.out.println("0");
            else System.out.println("-1");
            return;
        }

        for (int i = 0; i < N-2; i++) {
            for (int j = 0; j < M-2; j++) {
                if (inputMap[i][j] != resultMap[i][j]) {
                    changeMapValue(i, j);
                    answer += 1;
                }
            }
        }

        if (!isSameMatrix()) answer = -1;

        System.out.println(answer);
    }
    static boolean isSameMatrix() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(inputMap[i][j] != resultMap[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
    static void changeMapValue(int startY, int startX) {
        for (int i = startY; i < startY + 3; i++) {
            for (int j = startX; j< startX + 3; j++) {
                if(inputMap[i][j] == 1) inputMap[i][j] = 0;
                else inputMap[i][j] = 1;
            }
        }
    }
}