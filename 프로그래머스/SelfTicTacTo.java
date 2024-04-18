import java.util.*;

class Solution {
  public int solution(String[] board) {
    String[][] tictacto = new String[board.length][board.length];
    // int answer = -1;
    int first = 0;
    int second = 0;

    for (int i = 0; i < board.length; i++) {
      String[] tmp = board[i].split("");
      for (int j = 0; j < tmp.length; j++) {
        tictacto[i][j] = tmp[j];
        if (tmp[j].equals("O"))
          first += 1;
        else if (tmp[j].equals("X"))
          second += 1;
      }
    }

    // 선공, 후공 순서 바꼈을 때
    if (first < second)
      return 0;

    // 틱택토가 완성되었는데 다음 순서가 진행되었을 때
    if (first >= second) {
      // 선공과 후공이 동시에 틱택토인 경우는 없음
      // 후공만 틱택토 일때를 제외
      int value = check(tictacto);
      if (first - second > 1 || (value == 1 && first == second) || (value == 2 && first - second >= 1))
        return 0;
    }

    // if (first == 0 && second == 0) return 1;

    return 1;
  }

  static int check(String[][] tictacto) {
    List<String> list = new ArrayList<>();
    // 가로
    for (int i = 0; i < tictacto.length; i++) {
      String wc = tictacto[i][1];
      if (wc.equals(tictacto[i][0]) && wc.equals(tictacto[i][2]))
        list.add(wc);
    }

    // 세로
    for (int i = 0; i < tictacto.length; i++) {
      String hc = tictacto[1][i];
      if (hc.equals(tictacto[0][i]) && hc.equals(tictacto[2][i]))
        list.add(hc);
    }

    // 대각선 - 3x3 고정이므로 가운데 좌표 고정
    String center = tictacto[1][1];
    // 왼쪽 대각선
    if (center.equals(tictacto[0][0]) && center.equals(tictacto[2][2]))
      list.add(center);
    if (center.equals(tictacto[0][2]) && center.equals(tictacto[2][0]))
      list.add(center);

    // if (list.size() > 0 && list.contains("O") && list.contains("X")) return 1;
    // else if (list.size() > 0 && !list.contains("O") && list.contains("X")) return
    // 2;
    if (list.size() > 0 && list.contains("O"))
      return 1;
    else if (list.size() > 0 && !list.contains("O") && list.contains("X"))
      return 2;

    return 0;
  }

}