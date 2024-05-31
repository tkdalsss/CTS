import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int s = sc.nextInt();
        int[] numbers = new int[n+1];

        for (int i = 0; i < n; i++) {
             numbers[i] = sc.nextInt();
        }

        int min = Integer.MAX_VALUE;
        int start = 0;
        int end = 0;
        int total = 0;
        while (start <= n && end <= n) {
            if (total >= s && min > end - start) min = end - start;
            if (total < s) total += numbers[end++];
            else total -= numbers[start++];
        }

        if (min == Integer.MAX_VALUE) System.out.println("0");
        else System.out.println(min);
    }

}