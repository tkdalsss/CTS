package CTS.Java.Plus;

import java.util.*;

class WordTranslate {
    
    public static boolean[] visited;
    public static int[] dis ;
    public static int answer = 0;

    static class Word {
      String str;
      int idx;
      
      public Word (String str, int idx) {
          this.str = str;
          this.idx = idx;
      }
    }
  
    public int solution(String begin, String target, String[] words) {
    
        visited = new boolean[words.length];
        dis = new int[words.length+1];
        
        if(Arrays.asList(words).contains(target)){
            bfs(begin, target, words);
            return answer;   
        } else {
            return 0;
        }
        
    }
    
    static void bfs(String begin, String target, String[] words) {
        Queue<Word> queue = new LinkedList<>();
        queue.add(new Word(begin, 0)); //단어와 idx를 함께 나타낸다.
        
        while(!queue.isEmpty()) {
            Word output = queue.poll();
            
            if(output.str.equals(target)) 
                return ;
            
             for(int i=0; i< words.length; i++) {
                int cnt = 0;
                String next = words[i];
                 
                if(visited[i]) continue;
                else {
                    for(int j=0; j<output.str.length(); j++) {
                        if(next.charAt(j) == output.str.charAt(j)){
                            cnt++;
                        } 
                    }
                    
                    if(cnt == output.str.length()-1) {
                        visited[i] = true;
                        queue.add(new Word(words[i], i+1)); //단어와 idx를 함께 나타낸다.
                        dis[i+1] = dis[output.idx] + 1; //이것을 위해 StringANDIdx 의 형태로 단어와 idx를 함께 queue에 저장해두었다.
                        answer = dis[i+1];
                    }
                }
            }
        }
    }
}