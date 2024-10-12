import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        Stack<Character> stack = new Stack<>();

        int result = 0;
        int value = 1;

        for (int i = 0 ; i < s.length(); i++){
            if (s.charAt(i) == '(') {
                stack.push('(');
                value *= 2;
            } else if (s.charAt(i) == '[') {
                stack.push('[');
                value *= 3;
            } else if (s.charAt(i) == ')') {
                if (stack.isEmpty() || stack.peek() != '(') {
                    result = 0;
                    break;
                } else if (s.charAt(i - 1) == '(') {
                    result += value;
                }
                value /= 2;
                stack.pop();
            } else if (s.charAt(i) == ']') {
                if (stack.isEmpty() || stack.peek() != '[') {
                    result = 0;
                    break;
                } else if (s.charAt(i - 1) == '[') {
                    result += value;
                }
                value /= 3;
                stack.pop();
            }
        }
    
        if(!stack.isEmpty()) result = 0;
        System.out.println(result);
    }
}