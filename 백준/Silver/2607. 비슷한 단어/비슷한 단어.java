import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String standard = br.readLine();
        int[] alphabet = new int[26];
        int answer = 0;

        for (int i = 0; i < N-1; i++) {
            String input = br.readLine();
            int cnt = 0;

            for (int j = 0; j < standard.length(); j++) {
                alphabet[standard.charAt(j) - 'A'] += 1;
            }

            for (int j = 0; j < input.length(); j++) {
                if (alphabet[input.charAt(j) - 'A'] > 0) {
                    cnt += 1;
                    alphabet[input.charAt(j) - 'A'] -= 1;
                }
            }

            if (standard.length() == input.length() && (standard.length()-1 == cnt || standard.length() == cnt)) answer += 1;
            else if (standard.length() == input.length() - 1 && input.length() - 1 == cnt) answer += 1;
            else if (standard.length() == input.length() + 1 && input.length() == cnt) answer += 1;
        }

        System.out.println(answer);
    }
}