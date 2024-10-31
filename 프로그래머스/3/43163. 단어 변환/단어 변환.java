

import java.util.*;

class Solution {
    static boolean[] visited;
    static int answer;
    public int solution(String begin, String target, String[] words) {
        visited = new boolean[words.length];
        
        dfs(begin, target, words, 0);
        
        return answer;
    }
    static void dfs(String begin, String target, String[] words, int cnt) {
        // 일치한 단어를 찾았을 경우
        if (begin.equals(target)) {
            answer = cnt;
            return;
        }
        
        // 하나씩 바뀌는 단어를 찾아가는 과정
        for (int i = 0; i < words.length; i++) {
            if (visited[i]) continue;
            
            int k = 0;
            for (int j = 0; j < begin.length(); j++) {
                if (begin.charAt(j) == words[i].charAt(j)) k += 1;
            }
            
            if (k == words[i].length() - 1) {
                visited[i] = true;
                dfs(words[i], target, words, cnt+1);
                visited[i] = false;
            }
        }
    }
}