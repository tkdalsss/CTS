import java.util.*;
class Solution {
    public int solution(String[][] book_time) {
        int answer = 0;
        int[][] time_table = new int[book_time.length][2];
        for(int i = 0; i < book_time.length; i++) {
            String[] time1 = book_time[i][0].split(":");
            String[] time2 = book_time[i][1].split(":");
            time_table[i][0] = Integer.parseInt(time1[0]) * 60 + Integer.parseInt(time1[1]);
            time_table[i][1] = Integer.parseInt(time2[0]) * 60 + Integer.parseInt(time2[1]);
        }
        
        Arrays.sort(time_table, (o1, o2) -> (o1[0] - o2[0]));
        int room = 1;
        // List<Integer> timeList = new ArrayList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>();;
        pq.add(time_table[0][0]);
        // int currentTime = time_table[0][0];
        
        for (int[] tt : time_table) {
            // 끝나는 시간과 비교해서 끝나는 시간과 시작시간.
            int time = pq.poll();
            // System.out.println(time + " " + tt[0]);
            pq.add(tt[1]+10);
            if (time == tt[0]) continue;
            if (time > tt[0]) {
                room += 1;
                pq.add(time);
            }
        }
        
        return room;
    }
}