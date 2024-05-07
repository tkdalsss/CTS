class Solution {
    public long solution(int k, int d) {
        long answer = 0;
        for (int i = 0; i <= d; i+=k) {
            int tmp = (int) Math.sqrt(Math.pow(d, 2) - Math.pow(i,2));
            answer += 1 + tmp/k;
        }
        return answer;
    }
}