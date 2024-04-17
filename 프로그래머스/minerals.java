import java.util.*;
import java.util.stream.*;

class Solution {
  static List<List<Integer>> list = new ArrayList<>();

  public int solution(int[] picks, String[] minerals) {
    int answer = 0;
    int[][] pickPiro = {
        { 1, 1, 1 },
        { 5, 1, 1 },
        { 25, 5, 1 }
    };

    int pickPerMineral = (int) Math.ceil((double) minerals.length / 5);
    int[][] piroPerPick = new int[picks.length][pickPerMineral];

    for (int i = 0; i < picks.length; i++) {

      int idx = 0;
      int pickCntIdx = 0;
      int totalIdx = 0;
      int tmpPiro = 0;

      // 곡괭이 하나당 최소?
      while (true) {

        // 무조건 5개까지만 캘수 있음
        if (totalIdx == minerals.length) {
          piroPerPick[i][pickCntIdx] = tmpPiro;
          break;
        }

        if (minerals[totalIdx].equals("diamond")) {
          tmpPiro += pickPiro[i][0];
        } else if (minerals[totalIdx].equals("iron")) {
          tmpPiro += pickPiro[i][1];
        } else {
          tmpPiro += pickPiro[i][2];
        }

        idx += 1;
        totalIdx += 1;

        if (idx == 5) {
          idx = 0;
          piroPerPick[i][pickCntIdx] = tmpPiro;
          pickCntIdx += 1;
          tmpPiro = 0;
        }

      }

    }

    for (int i = 0; i < piroPerPick[0].length; i++) {
      int min = Integer.MAX_VALUE;
      int idx = 0;
      for (int j = 0; j < piroPerPick.length; j++) {
        if (picks[j] > 0) {
          if (min > piroPerPick[j][i]) {
            min = piroPerPick[j][i];
            idx = j;
          }
        }
      }
      picks[idx] = picks[idx] - 1;
      answer += min;
      if (Arrays.stream(picks).max().getAsInt() == 0)
        break;
    }
    return answer;
  }
}