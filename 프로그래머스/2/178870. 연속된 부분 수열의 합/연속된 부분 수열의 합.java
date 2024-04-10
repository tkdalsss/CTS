import java.util.*;
class Solution {
    static Queue<int[]> q = new LinkedList<>();
    
    public int[] solution(int[] sequence, int k) {
        
        int n = sequence.length;
        int front = 0;
        int rear = n;
        int sum = 0;
        
        for (int f = 0, r = 0; f < n; f++) {
            while (r < n && sum < k) {
                sum += sequence[r];
                r = r + 1;
            }
            
            if (sum == k) {
                int diff = r - f;
                if (rear - front + 1 > diff) {
                    rear = r-1;
                    front = f;
                }
            }
            
            sum -= sequence[f];
        }
        int[] answer = new int[]{front, rear};
        
        return answer;
    }
//         int[] answer = {};
        
//         for (int i = 0; i < sequence.length; i++) {
//             int sum = sequence[i];
//             int startIdx = i;
//             for (int j = i+1; j < sequence.length; j++) {
//                 sum += sequence[j];
//                 // System.out.println(j + " " + sum);
//                 if (sum == k) {
//                     q.add(new int[]{startIdx, j});
//                     break;
//                 } else if (sum > k) break;
//             }
//             if (sum == k && i+1 == sequence.length) {
//                 q.add(new int[]{startIdx, startIdx});
//             }
//         }
//         //System.out.println(q.toString());
//         answer = findMinSequence();
        
//         return answer;
//     }
    

//     static int[] findMinSequence() {
//         int min = Integer.MAX_VALUE;
//         int[] find = new int[2];
//         while(!q.isEmpty()) {
//             int[] tmp = q.poll();
//             // System.out.println(Arrays.toString(tmp));
//             if ((tmp[1] - tmp[0]) < min) {
//                 min = tmp[1] - tmp[0];
//                 find = tmp;
//             }
//         }
//         // System.out.println(Arrays.toString(find));
//         return find;
//     }
}