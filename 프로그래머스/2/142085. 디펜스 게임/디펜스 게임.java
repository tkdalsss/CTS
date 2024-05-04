import java.util.*;
class Solution{
    public int solution(int n, int k, int[] enemy) {
        int answer = enemy.length;
        Queue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        for (int i = 0; i < enemy.length; i++) {
            n -= enemy[i];
            pq.add(enemy[i]);
            
            if (n < 0) {
                if (k > 0 && !pq.isEmpty()){
                    n += pq.poll();
                    k--;
                } else {
                    answer = i;
                    break;
                }
            }
        }
        
        return answer;
    }
}
// class Solution {
//     static int[] ene;
//     static List<Integer> resultList = new ArrayList<>();
//     public int solution(int n, int k, int[] enemy) {
//         ene = enemy;
        
//         // 무적권이 적의 수만큼 있을 경우 return
//         if (k == enemy.length) return enemy.length;
        
//         dfs(n, k, 1);
        
//         return resultList.stream().mapToInt(x -> x).max().getAsInt();
//     }
//     static void dfs(int n, int k, int depth) {
//         if (depth > ene.length || n < 0 || k < 0) return;
//         if (n == 0) {
//             resultList.add(depth-1);
//             return;
//         }
        
//         for (int i = 0; i < 2; i++) {
//             if (i == 0) dfs(n, k-1, depth + 1);
//             else dfs(n-ene[depth-1], k, depth + 1);
//         }
//     }
// }