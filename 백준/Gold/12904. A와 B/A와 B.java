import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Queue;

public class Main {
    static Queue<Integer> result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder s = new StringBuilder(br.readLine());
        StringBuilder t = new StringBuilder(br.readLine());

        while (s.length() < t.length()) {
            if (t.charAt(t.length() - 1) == 'A'){
                t.deleteCharAt(t.length() - 1);
            } else if (t.charAt(t.length() - 1) == 'B') {
                t.deleteCharAt(t.length() -1);
                t.reverse();
            }
        }

        System.out.println(t.toString().contentEquals(s) ? 1 : 0);
    }
}