import java.util.*;
class Solution {
    public int solution(int[] order) {
        int answer = 0;
        int[] priority = new int[order.length];
        Stack<Integer> stack = new Stack<>();
        
        for (int i = 0; i < order.length; i++) {
            priority[order[i] - 1] = i;
        }
        
        for (int i = 0; i < priority.length; i++) {
            if (priority[i] == answer) answer += 1;
            else stack.push(priority[i]);
            while(!stack.isEmpty() && stack.peek() == answer) {
                stack.pop();
                answer += 1;
            }
        }
        
        return answer;
    }
}