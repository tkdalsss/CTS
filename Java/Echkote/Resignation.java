package CTS.Java.Echkote;

import java.util.*;

public class Resignation {

  static int n;
  static int[] t = new int[15];
  static int[] p = new int[15];
  static int[] dp = new int[16];
  static int maxValue;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    n = sc.nextInt();

    for (int i = 0; i < n; i++) {
      t[i] = sc.nextInt();
      p[i] = sc.nextInt();
    }

    for (int i = n - 1; i >= 0; i--) {
      int time = t[i] + i;
      // 상담이 기간 안에 끝나는 경우
      if (time <= n) {
        // 점화식에 맞게 현재까지의 최고 이익 계산
        dp[i] = Math.max(p[i] + dp[time], maxValue);
        maxValue = dp[i];
      }
      // 상담이 기간을 벗어나는 경우
      else
        dp[i] = maxValue;
    }

    sc.close();
  }

}
