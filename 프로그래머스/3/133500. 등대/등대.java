import java.util.*;

class Solution {
    static int N, result = 0;
    static List<List<Integer>> list = new ArrayList<>();
    
    public int dfs(int cur, int before) {
        if (list.get(cur).size() == 1 && list.get(cur).get(0) == before)
            return 1;
        
        int tmpRes = 0;
        for (int i = 0; i < list.get(cur).size(); i++) {
            int next = list.get(cur).get(i);
            if (next == before) continue;
            tmpRes += dfs(next, cur);
        }
        
        // System.out.println(tmpRes + " " + cur);
        
        // 해당 노드가 불을 키지 않아도 될 때
        if (tmpRes == 0) return 1;
        
        result++;
        return 0;
    } 
    
    public int solution(int n, int[][] lighthouse) {
        // int answer = 0;
        N = n;
        for (int i = 0; i <= N; i++) 
            list.add(new ArrayList<>());
        
        for (int i = 0; i < lighthouse.length; i++) {
            list.get(lighthouse[i][0]).add(lighthouse[i][1]);
            list.get(lighthouse[i][1]).add(lighthouse[i][0]);
        }
        
        dfs(1, 0);
        return result;
    }
}