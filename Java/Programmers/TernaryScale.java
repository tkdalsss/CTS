package CTS.Java.Programmers;

public class TernaryScale {
  public int solution(int n) {
    String str = Integer.toString(n, 3);
    String reversed = new StringBuilder(str).reverse().toString();
    return Integer.valueOf(reversed, 3);
  }
}
