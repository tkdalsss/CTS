import java.util.*;
class Solution {
    public int[] solution(int[] answers) {
        int[] first = {1,2,3,4,5};
        int[] second = {2,1,2,3,2,4,2,5};
        int[] third = {3,3,1,1,2,2,4,4,5,5};
        int[] scores = new int[3];
        
        for (int i = 0; i < answers.length; i++) {
            int answer = answers[i];
            if (answer == first[i%first.length]) scores[0] += 1;
            if (answer == second[i%second.length]) scores[1] += 1;
            if (answer == third[i%third.length]) scores[2] += 1;
        }
        
        int max = 0;
        for (int i = 0; i < scores.length; i++){
            max = Math.max(max, scores[i]);
        }
        
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < scores.length; i++) {
            if (scores[i] == max) list.add(i+1);
        }
        
        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}