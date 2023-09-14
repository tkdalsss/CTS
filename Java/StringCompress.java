package CTS.Java;

public class StringCompress {
  public int solution(String s) {
    int answer = s.length();

    // 1개씩 늘려가면서 확인
    for (int step = 1; step < s.length() / 2 + 1; step++) {

      String compressed = "";
      String prev = s.substring(0, step);
      int cnt = 1;

      // 단위(step) 크기만큼 증가시키며 이전 문자열과 비교
      for (int j = step; j < s.length(); j += step) {

        String sub = "";

        for (int k = j; k < j + step; k++) {
          if (k < s.length())
            sub += s.charAt(k);
        }

        if (prev.equals(sub))
          cnt += 1;
        else {
          compressed += (cnt >= 2) ? cnt + prev : prev;
          sub = "";
          for (int t = j; t < j + step; t++) {
            if (t < s.length())
              sub += s.charAt(t);
          }
          prev = sub;
          cnt = 1;
        }

      }
      // 남아있는 문자열에 대해서 처리
      compressed += (cnt >= 2) ? cnt + prev : prev;
      // 만들어지는 압축 문자열이 가장 짧은 것이 정답
      answer = Math.min(answer, compressed.length());
    }

    return answer;
  }
}
