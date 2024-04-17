
class Solution {
    public long solution(int r1, int r2) {
        long answer = 0;
        
        // x2 + y2 = r2
        long r1x = (long) Math.pow(r1, 2);
        long r2x = (long) Math.pow(r2, 2);
        long side = 0;
        
        for (long i = 0; i <= r2; i++) {
            long y2 = (long) Math.sqrt(r2x-(long) Math.pow(i,2));
            long y1 = (long) Math.sqrt(r1x-(long) Math.pow(i,2));
            
            // important
            if (Math.sqrt((r1x-Math.pow(i,2))) % 1 == 0) side += 1;
            
            //System.out.println(side);
            answer += (y2 - y1) * 4;
        }
        answer += side * 4 - 4;
        
        return answer;
//         long zeroCnt = 0;
        
//         for (int i = 0; i <= r2; i++) {
//             for (int j = 0; j <= r2; j++) {
//                 // 반지름 구하기
//                 double dist = Math.sqrt(i*i + j*j);
//                 if (dist >= (double) r1 & dist <= (double) r2) {
//                     // System.out.println(i + " " + j);
//                     // 정수 체크?
//                     answer += 1;
//                     if (i == 0 || j == 0) zeroCnt += 1;
//                 }
//             }
//         }
//         answer = answer * 4 - zeroCnt * 2;
    }
}