import java.util.*;
class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        int n = discount.length - 10 + 1;
        HashMap<String, Integer> wantMap = new HashMap<>();
        
        // 해시 사용
        for (int i = 0; i < want.length; i++) {
            wantMap.put(want[i], number[i]); // 기본 정보 입력
        }
        
        for (int i = 0; i < n; i++) {
            HashMap<String, Integer> disMap = new HashMap<>();
            for (int j = i; j < i + 10; j++) {
                disMap.put(discount[j], disMap.getOrDefault(discount[j], 0) + 1);
            }
            
            boolean isIdentical = true;
            
            for (String key : disMap.keySet()) {
                if(wantMap.get(key) != disMap.get(key)) {
                    isIdentical = false;
                    break;
                }
            }
            
            answer += isIdentical ? 1 : 0;
            
        }
        
        return answer;
    }
}