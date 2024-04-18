class Solution {
    public long solution(int[] sequence) {
        int a = 1, b = -1, s = sequence.length;
        long aSum = sequence[0], bSum = sequence[0] * -1, aMin = 0, bMin = 0, max = Long.MIN_VALUE;
        
        // 누적합
        for (int i = 1; i <= s; i++) {
            a *= -1;
            b *= -1;
            
            max = Math.max(max, aSum - aMin);
            max = Math.max(max, bSum - bMin);
            
            aMin = Math.min(aSum, aMin);
            bMin = Math.min(bSum, bMin);
            
            if (i == s) break;
            
            aSum += sequence[i] * a;
            bSum += sequence[i] * b;
        }
        
        return max;
    }
}