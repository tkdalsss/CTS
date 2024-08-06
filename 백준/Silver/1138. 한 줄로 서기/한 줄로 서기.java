import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static class Person{
        private int idx;
        private int left;

        public Person(int idx, int left) {
            this.idx = idx;
            this.left = left;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] answer = new int[N];
        boolean[] finished = new boolean[N];
        List<Person> personList = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            personList.add(new Person(i+1, Integer.parseInt(st.nextToken())));
        }
        
        int idx = 0;
        while(true) {
            out: for (Person p : personList) {
                if (finished[p.idx - 1]) continue;

                int cnt = 0;
                for (int i = 0; i < N; i++) {
                    if (answer[i] > p.idx) cnt += 1;
                }
                if (cnt == p.left) {
                    finished[p.idx - 1] = true;
                    answer[idx] = p.idx;
                    idx += 1;
                    break out;
                }
            }
            if (answer[N - 1] > 0) break;
        }

        for (int i : answer) {
            System.out.print(i + " ");
        }
    }
}