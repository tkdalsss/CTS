import java.util.*;
class Solution {
    public int solution(int n, int[] stations, int w) {
        // greedy
        int answer = 0;
        int sidx = 0;
        int cur = 1;
        
        while (cur <= n) {
            if (sidx < stations.length && cur >= stations[sidx] - w) {
                cur = stations[sidx] + w + 1;
                sidx += 1;
            } else {
                answer += 1;
                cur += (w*2) + 1;
            }
        }
        
        return answer;
        
//         int answer = 0;
//         int width = 2 * w + 1;
//         // 가다가 체크하고 길이만큼 앞 뒤 자르고
//         // 빈공간을 배열에?
//         boolean[] checked = new boolean[n];
//         List<Integer> list = new ArrayList<>();
        
//         for (int s : stations) {
//             for(int k = s-w; k <= s+w; k++) {
//                 if (k < 0 || k > n) break;
//                 checked[k-1] = true;
//             }
//         }
        
//         int term = 0;
//         for (int i = 0; i < n; i++) {
//             // System.out.println(term);
//             if (checked[i] || i == n-1) {
//                 list.add(term);
//                 term = 0;
//                 continue;
//             }
//             term += 1;
//         }
        
//         for (int i = 0; i < list.size(); i++) {
//             int tmp = list.get(i);
//             if (tmp == 0) continue;
//             if (tmp % width != 0) answer += tmp/width + 1;
//             else answer += tmp/width;
//         }
//         // System.out.println(list.toString());

//         return answer;
    }
}