class Solution {
    public int[] solution(int m, int n, int startX, int startY, int[][] balls) {
        int[] answer = new int[balls.length];
        
        for (int i = 0; i < balls.length; i++) {
            int tmpX = balls[i][0];
            int tmpY = balls[i][1];
            
            int cur, len = Integer.MAX_VALUE;
            
            if (!(startX == tmpX && startY <= tmpY)) {
                cur = calDist(startX, startY, tmpX, n + (n - tmpY));
                len = cur < len ? cur : len;
            }
            if (!(startX == tmpX && startY >= tmpY)) {
                cur = calDist(startX, startY, tmpX, tmpY * (-1));
                len = cur < len ? cur : len;
            }
            if (!(startY == tmpY && startX <= tmpX)) {
                cur = calDist(startX, startY, m + (m - tmpX), tmpY);
                len = cur < len ? cur : len;
            }
            if (!(startY == tmpY && startX >= tmpX)) {
                cur = calDist(startX, startY, tmpX * (-1), tmpY);
                len = cur < len ? cur : len;
            }
            
            answer[i] = len;
        }
        
        return answer;
    }
    
    public static int calDist(int startX, int startY, int tmpX, int tmpY) {
        return (int) (Math.pow(startX-tmpX, 2) + Math.pow(startY - tmpY, 2));
    }
}