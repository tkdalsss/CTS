import java.util.*;
class Solution {
    public int solution(String s) {
        int answer = 0;
        String str = s;
        
        for (int i = 0; i < s.length(); i++) {
            if (check(str)) answer++;
            str = str.substring(1, s.length()) + str.charAt(0);
        }
        
        return answer;
    }
    
    static boolean check(String str) {
        Stack<Character> stk = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            try {
                switch(str.charAt(i)) {
                    case '[':
                        stk.add('[');
                        break;
                    case ']':
                        if(stk.peek() != '[') return false;
                        stk.pop();
                        break;
                    case '(':
                        stk.add('(');
                        break;
                    case ')':
                        if(stk.peek() != '(') return false;
                        stk.pop();
                        break;
                    case '{':
                        stk.add('{');
                        break;
                    case '}':
                        if(stk.peek() != '{') return false;
                        stk.pop();
                        break;
                }
            } catch (Exception e) {
                return false;
            }
        }
        return stk.isEmpty() ? true : false;
    }
}