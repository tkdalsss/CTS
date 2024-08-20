import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static String[][] map;
    static List<int[]> bomb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        bomb = new ArrayList<>();
        map = new String[R][C];
        for (int i = 0; i < R; i++) {
            String line = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = line.substring(j, j + 1);
            }
        }

        int cnt = 2;
        while(cnt <= N) {
            if (cnt % 2 == 0) {
                for (int i = 0; i < R; i++) {
                    for (int j = 0; j < C; j++) {
                        if (map[i][j].equals("O")) {
                            bomb.add(new int[]{i, j});
                        }
                        map[i][j] = "O";
                    }
                }
            } else {
                for (int[] b : bomb) {
                    int x = b[0];
                    int y = b[1];

                    map[x][y] = ".";
                    if (x > 0 && x < R - 1) {
                        map[x - 1][y] = ".";
                        map[x + 1][y] = ".";
                    } else if (x < R - 1) {
                        map[x + 1][y] = ".";
                    } else if (x > 0) {
                        map[x - 1][y] = ".";
                    }

                    if (y > 0 && y < C - 1) {
                        map[x][y - 1] = ".";
                        map[x][y + 1] = ".";
                    } else if (y < C - 1) {
                        map[x][y + 1] = ".";
                    } else if (y > 0) {
                        map[x][y - 1] = ".";
                    }
                }
                bomb = new ArrayList<>();
            }
            cnt += 1;
        }

        for (String[] m : map) {
            for (String s : m) {
                System.out.print(s);
            }
            System.out.println();
        }
    }
}