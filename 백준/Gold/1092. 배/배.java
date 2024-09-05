import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Integer[] cranes = new Integer[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            cranes[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(cranes, Collections.reverseOrder());

        int M = Integer.parseInt(br.readLine());
        List<Integer> boxes = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            boxes.add(Integer.parseInt(st.nextToken()));
        }
        Collections.sort(boxes, Collections.reverseOrder());

        if (cranes[0] < boxes.get(0)) {
            System.out.println(-1);
            return;
        }

        int cnt = 0;
        while (!boxes.isEmpty()) {
            int index = 0;
            for (int i = 0; i < N;) {
                if (index == boxes.size()) break;
                else if (cranes[i] >= boxes.get(index)) {
                    boxes.remove(index);
                    i += 1;
                } else {
                    index += 1;
                }
            }
            cnt += 1;
        }

        System.out.println(cnt);
    }
}