import java.util.*;
class Solution {
    static Point[] dp;
    
    static class Point {
        int n, c;
        public Point(int n, int c) {
            this.n = n;
            this.c = c;
        }
    }
    
    static void calDp(int e) {
        dp = new Point[e];
        
        for (int i = 1; i <= e; i++) {
            // 숫자, 억억단 내 갯수
            dp[i-1] = new Point(i, 1);
        }
        
        for (int i = 2; i <= e; i++) {
            for (int j = 1; j <= e / i; j++) {
                dp[i * j - 1].c += 1;
            }
        }
        
        Arrays.sort(dp, new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                if (o1.c < o2.c) return 1;
                else if (o1.c > o2.c) return -1;
                else {
                    if (o1.n > o2.n) return 1;
                    else if (o1.n < o2.n) return -1;
                    else return 0;
                }
            }
        });
    }
    
    public int[] solution(int e, int[] starts) {
        int[] answer = new int[starts.length];
        calDp(e);
        
        for (int i = 0; i < starts.length; i++) {
            int s = starts[i];
            for (int j = 0; j < e; j++) {
                if (dp[j].n >= s) {
                    answer[i] = dp[j].n;
                    break;
                }
            }
        }
        return answer;
    }
}