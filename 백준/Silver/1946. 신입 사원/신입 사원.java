import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Record implements Comparable<Record> {
        private int document;
        private int interview;

        public Record(int document, int interview) {
            this.document = document;
            this.interview = interview;
        }

        @Override
        public int compareTo(Record other) {
            return this.document - other.document;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine()); // 테스트 케이스 묶음 수

        for (int i = 0; i < T; i++) {
            int cnt = 1;
            int N = Integer.parseInt(br.readLine()); // 테스트 케이스 수
            List<Record> ranks = new ArrayList<>();

            for (int j = 0; j < N; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                ranks.add(new Record(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
            }

            Collections.sort(ranks);
            int min = ranks.get(0).interview;

            for (int k = 1; k < N; k++) {
                if (ranks.get(k).interview < min) {
                    // 동석차 없이 결정되므로 equals 제외
                    min = ranks.get(k).interview;
                    cnt += 1;
                }
            }

            System.out.println(cnt);
        }

    }
}