import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Candidate {
        private int num;
        private int cnt;
        private int time;

        public Candidate(int num, int cnt, int time) {
            this.num = num;
            this.cnt = cnt;
            this.time = time;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); // 사진틀 개수
        int r = Integer.parseInt(br.readLine()); // 추천 개수

        PriorityQueue<Candidate> candidates = new PriorityQueue<>((c1, c2) -> {
            if (c1.cnt != c2.cnt) {
                return Integer.compare(c1.cnt, c2.cnt);
            } else {
                return Integer.compare(c1.time, c2.time);
            }
        });

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < r; i++) {
            int candidateNum = Integer.parseInt(st.nextToken());

            if (!isExist(candidates, candidateNum)) {
                if (candidates.size() >= N) {
                    candidates.poll();
                }
                candidates.add(new Candidate(candidateNum, 1, i));
            }
        }

        List<Candidate> list = new ArrayList<>(candidates);
        list.sort(Comparator.comparingInt(c -> c.num));
        for (Candidate candidate : list) {
            System.out.print(candidate.num + " ");
        }
    }
    static boolean isExist(PriorityQueue<Candidate> pq, int num) {
        Iterator<Candidate> it = pq.iterator();
        while (it.hasNext()) {
            Candidate candidate = it.next();
            if (candidate.num == num) {
                it.remove();
                candidate.cnt += 1;
                pq.add(candidate);
                return true;
            }
        }
        return false;
    }
}