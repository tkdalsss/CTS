import java.util.*;
class Solution {
    public int solution(int storey) {
        int answer = 0;
        
        while (storey > 0) {
            int comp = storey % 10;
            storey = storey / 10;
            
            if (comp <= 5) {
                if (storey % 10 >= 5 && comp == 5) storey += 1;
                answer += comp;
            } else {
                answer += 10 - comp;
                storey += 1;
            }
            //System.out.println(answer);
        }
        
        return answer;
    }
}