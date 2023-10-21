package CTS.Java.Plus;

import java.util.*;

public class WordTranslate {

  static boolean[] visited;

  static class Word {
    String word;
    int idx;

    public Word(String word, int idx) {
      this.word = word;
      this.idx = idx;
    }

    public String getWord() {
      return this.word;
    }

    public int getIdx() {
      return this.idx;
    }
  }

  public int solution(String begin, String target, String[] words) {
    int answer = 0;
    List<String> strList = new ArrayList<>(Arrays.asList(words));

    visited = new boolean[words.length];

    if (!strList.contains(target))
      return 0;

    Queue<Word> q = new LinkedList<>();
    q.offer(new Word(begin, 0));

    // 수정해야 함
    while (!q.isEmpty()) {
      Word tmp = q.poll();
      String word = tmp.getWord();
      int idx = tmp.getIdx();

      if (word == target) {
        answer = idx;
        break;
      }

      int tmp_idx;
      for (int i = 0; i < words.length; i++) {
        tmp_idx = 0;

        if (visited[i])
          continue;

        for (int j = 0; j < word.length(); j++) {
          if (word.charAt(j) != words[i].charAt(j))
            tmp_idx++;
        }

        if (tmp_idx == 1) {
          visited[i] = true;
          q.offer(new Word(words[i], idx + 1));
        }
      }
    }

    return answer;
  }
}
