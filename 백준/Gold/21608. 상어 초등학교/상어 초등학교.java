import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static int[] students;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int[][] map;
    static Map<Integer, HashSet<Integer>> preferences;

    static class Seat implements Comparable<Seat> {
        int x, y, preferSum, emptySeatSum;

        public Seat(int x, int y, int preferSum, int emptySeatSum) {
            this.x = x;
            this.y = y;
            this.preferSum = preferSum;
            this.emptySeatSum = emptySeatSum;
        }

        @Override
        public int compareTo(Seat otherSeat) {
            // 1. 비어있는 칸 중에 좋아하는 학생이 인접한 칸에 많은 칸
            if (this.preferSum != otherSeat.preferSum) return otherSeat.preferSum - this.preferSum;
            // 2. 여러 개 이면, 인접한 칸 중에서 비어있는 칸이 가장 많은 칸
            if (this.emptySeatSum != otherSeat.emptySeatSum) return otherSeat.emptySeatSum - this.emptySeatSum;
            // 3. 2를 만족하는 칸도 여러 개인 경우에는 행의 번호가 가장 작은 칸으로, 그러한 칸도 여러 개이면 열의 번호가 가장 작은 칸
            if (this.x != otherSeat.x) return this.x - otherSeat.x;
            return this.y - otherSeat.y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        students = new int[N * N];
        preferences = new HashMap<>();
        int answer = 0;

        for (int i = 0; i < N * N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int student = Integer.parseInt(st.nextToken());
            students[i] = student;
            preferences.put(student, new HashSet<>());
            for (int j = 0; j < 4; j++) {
                preferences.get(student).add(Integer.parseInt(st.nextToken()));
            }
        }

        for (int i = 0; i < N * N; i++) {
            Seat seat = findSeat(students[i]);
            map[seat.x][seat.y] = students[i];
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int count = calculatePreferSum(i, j, map[i][j]);
                if (count > 0) answer += (int) Math.pow(10, count - 1);
            }
        }

        System.out.println(answer);
    }
    static Seat findSeat(int student) {
        Seat resultSeat = null;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] > 0) continue;

                Seat curSeat = new Seat(i, j, calculatePreferSum(i, j, student), calculateEmptySum(i, j, student));
                if (resultSeat == null) {
                    resultSeat = curSeat;
                    continue;
                }

                if (resultSeat.compareTo(curSeat) > 0) {
                    resultSeat = curSeat;
                }
            }
        }
        return resultSeat;
    }
    static int calculatePreferSum(int x, int y, int student) {
        int result = 0;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;

            if (preferences.get(student).contains(map[nx][ny])) result += 1;
        }
        return result;
    }
    static int calculateEmptySum(int x, int y, int student) {
        int result = 0;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;

            if (map[nx][ny] == 0) result += 1;
        }
        return result;
    }
}