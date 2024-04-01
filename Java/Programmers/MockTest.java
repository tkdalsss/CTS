import java.util.stream.*;

public class MockTest {
  private static final int[][] randomPick = {
      { 1, 2, 3, 4, 5 },
      { 2, 1, 2, 3, 2, 4, 2, 5 },
      { 3, 3, 1, 1, 2, 2, 4, 4, 5, 5 }
  };

  static int[] solution(int[] answers) {
    int[] correct = new int[3];
    int max = 0;

    for (int i = 0; i < answers.length; i++) {
      for (int p = 0; p < randomPick.length; p++) {
        int picked = picked(i, p);
        if (picked == answers[i]) {
          // 제일 많이 맞춘 학생 추가
          if (++correct[p] > max) {
            max = correct[p];
          }
        }
      }
    }

    final int maxCorrects = max;

    return IntStream.range(0, 3).filter(i -> correct[i] == maxCorrects).toArray();
  }

  private static int picked(int answer, int person) {
    // answer -> 문제 번호, person -> 학생 정보
    // tmp : 학생의 문제 패턴
    int[] tmp = randomPick[person];
    // 나머지 연산을 통해 index 지정
    int index = answer % tmp.length;
    return tmp[index];
  }

  public static void main(String[] args) {
    int[] answer1 = { 1, 2, 3, 4, 5 };
    System.out.println(solution(answer1));
  }
}
