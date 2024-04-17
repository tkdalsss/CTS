import java.util.*;
class Solution {
    static class Mineral {
        int diamond, iron, stone;
        public Mineral(int diamond, int iron, int stone) {
            this.diamond = diamond;
            this.iron = iron;
            this.stone = stone;
        }
    }
    static int[][] scoreBoard;
    static List<Mineral> list;
    // static List<List<Integer>> list = new ArrayList<>();
    public int solution(int[] picks, String[] minerals) {
        int answer = 0;
        scoreBoard = new int[][]{{1,1,1},{5,1,1},{25,5,1}};
        
        int totalPicks = Arrays.stream(picks).sum();
        list = new ArrayList<>();
        for (int i = 0; i < minerals.length; i+=5) {
            if (totalPicks == 0) break;
            
            int dia = 0, iron = 0, stone = 0;
            for (int j = i; j < i + 5; j++) {
                if (j == minerals.length) break;
                
                String mineral = minerals[j];
                int val = mineral.equals("iron") ? 1 : mineral.equals("stone") ? 2 : 0;
            
                dia += scoreBoard[0][val];
                iron += scoreBoard[1][val];
                stone += scoreBoard[2][val];
            }
            
            list.add(new Mineral(dia, iron, stone));
            totalPicks -= 1;
        }
        
        Collections.sort(list, (o1, o2) -> (o2.stone - o1.stone));
        for (Mineral m : list) {
            int dia = m.diamond;
            int iron = m.iron;
            int stone = m.stone;
            
            if (picks[0] > 0) {
                answer += dia;
                picks[0]--;
                continue;
            }
            if (picks[1] > 0) {
                answer += iron;
                picks[1]--;
                continue;
            }
            if (picks[2] > 0) {
                answer += stone;
                picks[2]--;
                continue;
            }
        }
        
        return answer;
        // String[] pick = {"diamond", "iron", "stone"};
//         int[][] pickPiro = {
//             {1, 1, 1},
//             {5, 1, 1},
//             {25, 5, 1}
//         };
//         int pickPerMineral = (int) Math.ceil((double)minerals.length/5);
//         int[][] piroPerPick = new int[picks.length][pickPerMineral];
        
//         for (int i = 0; i < picks.length; i++) {
        
//                 int idx = 0;
//                 int pickCntIdx = 0;
//                 int totalIdx = 0;
//                 int tmpPiro = 0;
            
            // 곡괭이 하나당 최소?
                
//                 while(true) {
                    
//                     // 무조건 5개까지만 캘수 있음
//                     if (totalIdx == minerals.length) {
//                         piroPerPick[i][pickCntIdx] = tmpPiro;
//                         break;
//                     }

//                     if (minerals[totalIdx].equals("diamond")){
//                         tmpPiro += pickPiro[i][0];
//                     } else if (minerals[totalIdx].equals("iron")) {
//                         tmpPiro += pickPiro[i][1];
//                     } else {
//                         tmpPiro += pickPiro[i][2];
//                     }

//                     idx += 1;
//                     totalIdx += 1;

//                     if (idx == 5) {
//                         idx = 0;
//                         piroPerPick[i][pickCntIdx] = tmpPiro;
//                         pickCntIdx += 1;
//                         tmpPiro = 0;
//                     }

//                 }
            
//         }
//         // for(int[] ppp : piroPerPick) {
//         //     System.out.println(Arrays.toString(ppp));
//         // }
        
        
//         for (int i = 0; i < piroPerPick[0].length; i++) {
//             int min = Integer.MAX_VALUE;
//             int idx = 0;
//             for (int j = 0; j < piroPerPick.length; j++) {
                
//                 if (picks[j] > 0) {
//                     if (min > piroPerPick[j][i]) {
//                         min = piroPerPick[j][i];
//                         idx = j;
//                     }
//                 }
//             }
//             picks[idx] = picks[idx] - 1;
//             answer += min;
//             if (Arrays.stream(picks).max().getAsInt() == 0) break;
//         }
        
    }
}