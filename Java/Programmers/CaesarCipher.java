package CTS.Java.Programmers;

public class CaesarCipher {
  private char push(char c, int n) {
    if (!Character.isAlphabetic(c))
      return c;

    int offset = Character.isUpperCase(c) ? 'A' : 'a'; // 대문자인지 확인
    int position = c - offset;
    position = (position + n) % ('Z' - 'A' + 1);
    return (char) (offset + position);
  }

  public String solution(String s, int n) {
    StringBuilder sb = new StringBuilder();
    for (char c : s.toCharArray()) {
      sb.append(push(c, n));
    }
    return sb.toString();
  }
}