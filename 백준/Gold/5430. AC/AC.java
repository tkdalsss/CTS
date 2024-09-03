import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            String command = br.readLine();
            int numberCnt = Integer.parseInt(br.readLine());

            String input = br.readLine();
            Deque<String> dq = new LinkedList<>();
            if (numberCnt > 0) {
                String[] numbers = input.substring(1, input.length() -1).split(",");
                dq.addAll(Arrays.asList(numbers));
            }

            ac(command, dq);
        }
    }
    static void ac(String command, Deque<String> dq) {
        boolean isReversed = false;

        for (char c : command.toCharArray()) {
            if (c == 'R') isReversed = !isReversed;
            else {
                if (dq.isEmpty()) {
                    System.out.println("error");
                    return;
                }

                if (isReversed) dq.removeLast();
                else dq.removeFirst();
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append("[");

        while(!dq.isEmpty()) {
            sb.append(isReversed ? dq.removeLast() : dq.removeFirst());
            if (!dq.isEmpty()) sb.append(",");
        }

        sb.append("]");
        System.out.println(sb);
    }
}