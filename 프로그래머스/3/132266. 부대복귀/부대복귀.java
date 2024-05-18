import java.util.*;
class Solution {
    static int[] cost;
    static List<Integer>[] graph;
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        int[] answer = new int[sources.length];
        graph = new List[n+1];
        
        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for (int[] r: roads) {
            graph[r[0]].add(r[1]);
            graph[r[1]].add(r[0]);
        }
        
        cost = new int[n+1];
        Arrays.fill(cost, -1);
        bfs(destination);
        
        for (int i = 0; i < sources.length; i++) {
            answer[i] = cost[sources[i]];
        }
        
        return answer;
    }
    static void bfs(int destination) {
        Queue<Integer> q = new LinkedList<>();
        q.add(destination);
        cost[destination] = 0;
        
        while(!q.isEmpty()) {
            int cur = q.poll();
            int len = graph[cur].size();
            for (int i = 0; i < len; i++) {
                int next = graph[cur].get(i);
                if (cost[next] == -1) {
                    cost[next] = cost[cur] + 1;
                    q.add(next);
                }
            }
        }
    }
}