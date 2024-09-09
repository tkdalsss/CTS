import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static boolean[][] gear = new boolean[4][8];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 4; i++) {
            String state = br.readLine();
            setGear(i, state);
        }

        int K = Integer.parseInt(br.readLine());
        for (int i = 0; i < K; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken()) - 1;
            int direction = Integer.parseInt(st.nextToken());
            simulate(n, direction);
        }

        System.out.println(calculate());

    }
    static void setGear(int index, String state) {
        for (int j = 0; j < 8; j++) {
            gear[index][j] = state.charAt(j) == '1';
        }
    }
    static void simulate(int n, int direction) {
        boolean magnet = gear[n][2];
        int dir = direction;
        // 오른쪽 톱니바퀴들
        for (int i = n + 1; i < 4; i++) {
            if (gear[i][6] != magnet) {
                magnet = gear[i][2];
                dir *= -1;
                rotate(i, dir);
            } else break;
        }
        magnet = gear[n][6];
        dir = direction;
        // 왼쪽 톱니바퀴들
        for (int i = n - 1; i >= 0; i--) {
            if (gear[i][2] != magnet) {
                magnet = gear[i][6];
                dir *= -1;
                rotate(i, dir);
            } else break;
        }
        rotate(n, direction);
    }
    static void rotate(int n, int direction) {
        boolean tmp;
        if (direction == 1) {
            tmp = gear[n][7];
            for (int i = 7; i > 0; i--) {
                gear[n][i] = gear[n][i-1];
            }
            gear[n][0] = tmp;
        } else {
            tmp = gear[n][0];
            for (int i = 0; i < 7; i++) {
                gear[n][i] = gear[n][i+1];
            }
            gear[n][7] = tmp;
        }
    }
    static int calculate() {
        int sum = 0;
        for (int i = 0; i < 4; i++) {
            sum += gear[i][0] ? (int) Math.pow(2, i) : 0;
        }
        return sum;
    }
}