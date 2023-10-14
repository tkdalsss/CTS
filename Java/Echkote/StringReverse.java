package CTS.Java.Echkote;

import java.util.*;

public class StringReverse {

  public static String str;
  public static int count0 = 0;
  public static int count1 = 0;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    str = sc.next();

    if (str.charAt(0) == '1') {
      count0 += 1;
    } else {
      count1 += 1;
    }

    for (int i = 0; i < str.length(); i++) {
      if (str.charAt(i) != str.charAt(i + 1)) {
        // 다음 수에서 1로 바뀌는 경우
        if (str.charAt(i + 1) == '1')
          count0 += 1;
        // 다음 수에서 0으로 바뀌는 경우
        else
          count1 += 1;
      }
    }

    sc.close();
    System.out.println(Math.min(count0, count1));
  }
}
