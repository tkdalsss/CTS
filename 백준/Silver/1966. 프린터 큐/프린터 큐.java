import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt(); // 각각 테스트케이스에서 프린터의 개수
            int m = sc.nextInt(); // 중요도 순으로 정렬했을 때 몇번째 위치한 데이터 가져올지 -> 0번쨰 부터임

            LinkedList<int[]> q = new LinkedList<>();
            for (int i = 0; i < n; i++) {
                q.offer(new int[]{i, sc.nextInt()});
            }

            int count = 0;
            while (!q.isEmpty()) {
                int[] tmp = q.poll();
                boolean flag = false;

                for (int i = 0; i < q.size(); i++) {
                    if (tmp[1] < q.get(i)[1]) {
                        q.offer(tmp);
                        for (int j = 0; j < i; j++) {
                            q.offer(q.poll());
                        }
                        flag = true;
                        break;
                    }
                }

                if(flag) continue;

                count += 1;
                if(tmp[0] == m) break;
            }

            sb.append(count).append('\n');
        }

        System.out.println(sb);
    }
}