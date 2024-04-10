class Solution {
    public int solution(int h1, int m1, int s1, int h2, int m2, int s2) {
        // int answer = -1;
        int time1 = convertTime(h1, m1, s1);
        int time2 = convertTime(h2, m2, s2);
        
        int answer = overlap(time2) - overlap(time1) + (overlapNow(time1) ? 1: 0);
        
        return answer;
    }
    
    static int overlap(int time) {
        int oh = time * 719 / 43200;
        int om = time * 59 / 3600;
        int total = time >= 43200 ? 2 : 1;
        return oh + om - total;
    }
    
    static boolean overlapNow(int time) {
        return time * 59 % 3600 == 0 || time * 719 % 43200 == 0;
    }
    
    static int convertTime(int h, int m, int s) {
        return h*3600+m*60+s;
    }
    
}