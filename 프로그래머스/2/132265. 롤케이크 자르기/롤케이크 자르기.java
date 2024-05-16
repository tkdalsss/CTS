import java.util.*;
class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        int n = topping.length;
        int[] front = new int[topping.length];
        int[] rear = new int[topping.length];
        
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set.add(topping[i]);
            front[i] = set.size();
        }
        
        set = new HashSet<>();
        for (int i = n-1, count=0; i >=0; i--) {
            int tmp = topping[i];
            if (!set.contains(tmp)) {
                set.add(tmp);
                count += 1;
            }
            rear[i] = count;
        }
        
        for (int i = 0; i < n-1; i++) {
            if (front[i] == rear[i+1]) answer += 1;
        }
        
        return answer;
    }
}