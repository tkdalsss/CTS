import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int cnt = 1;

        while(true) {
            if (b <= a) break;

            if (b % 2 == 0) {
                b = b / 2;
            } else if (b % 10 == 1){
                b = b / 10;
            } else break;

            cnt += 1;
        }

        System.out.println(b == a ? cnt : -1);
    }
}