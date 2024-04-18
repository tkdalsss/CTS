import java.util.*;
class Solution {
    public int solution(int[][] scores) {
        int answer = 0;
        int size = scores.length;
        int n = scores[0][0]; // 원호 점수
        int m = scores[0][1];
        
        // 1. 근무태도 오름차순으로 일단 정렬
        Arrays.sort(scores, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o1[1] - o2[1];
            }
            return o2[0] - o1[0];
        });
        
        // 2. 그런 다음 동료 평가 내림차순으로 하면
        // 인센티브를 못받는 사람을 찾을 수 있다
        int maxScore = scores[0][1];
        for (int i = 1; i < size; i++) {
            // 인센티브를 못받는 경우 - 다른 임의의 사원보다 한번이라도 점수가 낮으면 안됨
            if (scores[i][1] < maxScore) {
                // 완호가 인센티브를 받지 못하는 경우
                if (scores[i][0] == n && scores[i][1] == m) return -1;
                scores[i][0] = -1; 
                scores[i][1] = -1;
            } else {
                maxScore = scores[i][1];
            }
        }
        
        // 3. 근무 + 동료 합친 점수를 내림차순으로 정렬해서 석차 구하기
        Arrays.sort(scores, (o1, o2) -> (o2[0] + o2[1]) - (o1[0] + o1[1]));
        answer = 1;
        
        for (int i = 0; i < size; i++) {
            // 석차 구하기
            if (scores[i][0] + scores[i][1] > n + m) {
                answer++;
            } else break;
        }
        
        return answer;
    }
}