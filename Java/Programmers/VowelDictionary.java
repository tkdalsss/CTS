package CTS.Java.Programmers;

import java.util.*;

public class VowelDictionary {
  private static final char[] CHARS = "AEIOU".toCharArray();

  private static void generate(String word, List<String> words) {
    words.add(word);
    if (word.length() == 5)
      return;
    for (char c : CHARS) {
      generate(word + c, words);
    }
  }

  private static int solution(String word) {
    List<String> words = new ArrayList<>();
    generate("", words);
    return words.indexOf(word);
  }

  public static void main(String[] args) {
    // String words = {"AAAAE", "AAAE"};
    System.out.println(solution("AAAAE"));
  }
}
