import java.util.*;
class Solution {
    static int[][] cost = {
        { 1, 7, 6, 7, 5, 4, 5, 3, 2, 3 },
        { 7, 1, 2, 4, 2, 3, 5, 4, 5, 6 },
        { 6, 2, 1, 2, 3, 2, 3, 5, 4, 5 },
        { 7, 4, 2, 1, 5, 3, 2, 6, 5, 4 },
        { 5, 2, 3, 5, 1, 2, 4, 2, 3, 5 },
        { 4, 3, 2, 3, 2, 1, 2, 3, 2, 3 },
        { 5, 5, 3, 2, 4, 2, 1, 5, 3, 2 },
        { 3, 4, 5, 6, 2, 3, 5, 1, 2, 4 },
        { 2, 5, 4, 5, 3, 2, 3, 2, 1, 2 },
        { 3, 6, 5, 4, 5, 3, 2, 4, 2, 1 }
    };
    static int[][][] dp;
    static String arr;
    static int len;
    
    public int solution (String numbers) {
        arr = numbers;
        len = numbers.length();
        
        dp = new int[len + 1][10][10];
        for (int i = 0; i < len + 1; i++) {
            for (int j = 0; j < 10; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }
        return solve(0, 4, 6);
    }
    
    static int solve(int ind, int L, int R) {
        if (ind == len) {
            return 0;
        }
        if (dp[ind][L][R] != -1) return dp[ind][L][R];
        
        int num = arr.charAt(ind) - '0';
        int result = Integer.MAX_VALUE;
        
        if (num != R) result = Math.min(solve(ind + 1, num, R) + cost[L][num], result);
        
        if (num != L) result = Math.min(solve(ind + 1, L, num) + cost[R][num], result);
        
        return dp[ind][L][R] = result;
    }
}
// import java.util.*;
// class Solution {
//     static int[][] map = {
//             {1,2,3},{4,5,6},{7,8,9},{10,11,12}
//     };
//     static int s1x = 1;
//     static int s1y = 0;
//     static int s2x = 1;
//     static int s2y = 2;
//     public static int solution(String numbers) {
//         int answer1 = 0;

//         String[] nums = numbers.split("");
//         boolean before = false; // left

//         for (int i = 0; i < nums.length; i++) {
//            int tmp1x = s1x;
//            int tmp1y = s1y;
//            int tmp2x = s2x;
//            int tmp2y = s2y;
//             int leftMin = bfs(4, 3, s1x, s1y, Integer.parseInt(nums[i]), 0);
//             int rightMin = bfs(4, 3, s2x, s2y, Integer.parseInt(nums[i]), 1);
//             // System.out.println(leftMin + " " + rightMin);
//             if (leftMin < rightMin) {
//                 answer1 += leftMin;
//                 before = false;
//                 s2x = tmp2x;
//                 s2y = tmp2y;
//             } else if (rightMin < leftMin) {
//                 answer1 += rightMin;
//                 before = true;
//                 s1x = tmp1x;
//                 s1y = tmp1y;
//             } else  {
//                 if (!before) {
//                     answer1 += leftMin;
//                     s2x = tmp2x;
//                     s2y = tmp2y;
//                 }
//                 else {
//                     answer1 += rightMin;
//                     s1x = tmp1x;
//                     s2y = tmp2y;
//                 }
//             }
//             // System.out.println(leftMin + " " + rightMin);
//             // System.out.println("===== " + answer1 + " =====");
//             // System.out.println(s1x + " " + s1y + " " + s2x + " " + s2y);
//         }
        
//         // System.out.println("+++++++");
//         s1x = 1;
//         s1y = 0;
//         s2x = 1;
//         s2y = 2;
        
//         before = false;
//         int answer2 = 0;
//         for (int i = 0; i < nums.length; i++) {
//            int tmp1x = s1x;
//            int tmp1y = s1y;
//            int tmp2x = s2x;
//            int tmp2y = s2y;
//             int leftMin = bfs(4, 3, s1x, s1y, Integer.parseInt(nums[i]), 0);
//             int rightMin = bfs(4, 3, s2x, s2y, Integer.parseInt(nums[i]), 1);
//             // System.out.println(leftMin + " " + rightMin);
//             if (leftMin < rightMin) {
//                 answer2 += leftMin;
//                 before = false;
//                 s2x = tmp2x;
//                 s2y = tmp2y;
//             } else if (rightMin < leftMin) {
//                 answer2 += rightMin;
//                 before = true;
//                 s1x = tmp1x;
//                 s1y = tmp1y;
//             } else  {
//                 if (before) {
//                     answer2 += leftMin;
//                     s2x = tmp2x;
//                     s2y = tmp2y;
//                 }
//                 else {
//                     answer2 += rightMin;
//                     s1x = tmp1x;
//                     s1y = tmp1y;
//                 }
//             }
//             // System.out.println(leftMin + " " + rightMin);
//             // System.out.println("===== " + answer2 + " =====");
//             // System.out.println(s1x + " " + s1y + " " + s2x + " " + s2y);
//         }

//         return Math.min(answer1, answer2);
//     }
//     static int bfs(int n, int m, int x, int y, int target, int current) {
//         int[][] dist = {
//                 {-1, -1, 3}, {-1, 0, 2}, {-1, 1, 3},
//                 {0, -1, 2}, {0, 0, 0}, {0, 1, 2},
//                 {1, -1, 3}, {1, 0, 2}, {1, 1, 3}
//         };

//         Queue<int[]> q = new LinkedList<>();
//         q.add(new int[]{x, y});
//         int[][] scoreMap = new int[n][m];
//         boolean[][] visited = new boolean[n][m];
//         // int totalScore = 0;
        
//         if (target == 0) target = 11;

//         while (!q.isEmpty()) {
//             int[] tmp = q.poll();
//             int nx = tmp[0];
//             int ny = tmp[1];

//             for (int i = 0; i < dist.length; i++) {
//                 int px = nx + dist[i][0];
//                 int py = ny + dist[i][1];
//                 int score = dist[i][2];

// //                System.out.println(px + " " + py);

//                 if (px < 0 || px >= n || py < 0 || py >= m || visited[px][py]) continue;
                
                
//                 if (map[px][py] == target) {
//                     if (current == 0) {
//                         s1x = px;
//                         s1y = py;
//                     } else {
//                         s2x = px;
//                         s2y = py;
//                     }
//                     scoreMap[px][py] = scoreMap[nx][ny] + score;
//                     if (score == 0) return scoreMap[px][py] + 1;
//                     return scoreMap[px][py];
//                 }

//                 visited[px][py] = true;
//                 scoreMap[px][py] = scoreMap[nx][ny] + score;
//                 q.add(new int[]{px,py});
//             }
//         }

//         return 0;
//     }
// }