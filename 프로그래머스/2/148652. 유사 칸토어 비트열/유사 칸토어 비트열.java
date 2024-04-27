class Solution {
    public int solution(int n, long l, long r) {
        return countCantoe(n, l, r, 1);
    }
    
    static int countCantoe(int n, long s, long e, long idx) {
        if (n == 0) return 1;
        int num = 0;
        long part = (long) Math.pow(5, n-1);
        for (int i = 0; i < 5; i++) {
            if (i == 2 || e < idx + part * i || (idx + part * (i+1) -1) < s) continue;
            num += countCantoe(n-1, s, e, idx + part * i);
        }
        return num;
    }
//     public int solution(int n, long l, long r) {
//         int answer = 0;
//         String cantoe = "1";
//         int idx = 1;
        
//         while(idx <= n) {
//             String tmpCantoe = "";
//             char[] tmpArr = cantoe.toCharArray();
//             for (int i = 0; i < tmpArr.length; i++) {
//                 if (tmpArr[i] == '0') tmpCantoe += "00000";
//                 else tmpCantoe += "11011";
//             }
//             cantoe = tmpCantoe;
//             idx += 1;
//         }
//         char[] toChar = cantoe.toCharArray();
//         for (long i = l; i <= r; i++) {
//             if (toChar[(int)i-1] == '1') {
//                 answer += 1;
//             }
//         }
//         return answer;
//     }
}