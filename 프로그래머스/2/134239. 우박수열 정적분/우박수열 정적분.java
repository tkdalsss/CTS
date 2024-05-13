import java.util.*;
class Solution {
    public double[] solution(int k, int[][] ranges) {
        double[] answer = new double[ranges.length];
        List<Integer> list = new ArrayList<>();
        
        while(true) {
            list.add(k);
            if (k <= 1) break;
            
            if (k % 2 == 0) k = k/2;
            else k = k * 3 + 1;
        }
        
        double[] area = new double[list.size()-1];
        for (int i = 0; i < list.size()-1; i++) {
            double height = Math.abs(list.get(i) - list.get(i+1));
            if (list.get(i+1) > list.get(i)) area[i] = (double) list.get(i) + (height/2);
            else area[i] = (double) list.get(i+1) + (height/2);
        }
        
        for (int i = 0; i < ranges.length; i++) {
            int a = ranges[i][0];
            int b = list.size() - 1 + ranges[i][1];
            double tmp = 0.0;
            if (a > b) {
                tmp = -1.0;
            } else {
                for (int j = a; j < b; j++) {
                    tmp += area[j];
                }
            }
            
            answer[i] = tmp;
        }
        
        return answer;
    }
}