import java.util.*;
class Solution {
    public int solution(int[] cards) {
        int answer = 0;
        List<Integer> list = new ArrayList<>();
        boolean[] visited = new boolean[cards.length];
        int idx = 0;
        
        for (int i = 0; i < cards.length; i++) {
            if (visited[i]) continue;
            if (calculateVisitedCnt(visited) == cards.length) break;
            int groupCnt = nextStepCard(cards, visited, i);
            if (cards.length - groupCnt <= 0) return 0;
            list.add(groupCnt);
        }
        // System.out.println(list);
        Collections.sort(list, Collections.reverseOrder());
        answer = list.get(0) * list.get(1);
        
        return answer;
    }
    static int nextStepCard(int[] cards, boolean[] visited, int idx) {
        int tmp = 0;
        while (true) {
            if (visited[idx]) break;
            visited[idx] = true;
            idx = cards[idx] - 1;
            tmp += 1;
        }
        return tmp;
    }
    static int calculateVisitedCnt(boolean[] visited){
        int count = 0;
        for (int i = 0; i < visited.length; i++) {
            if (visited[i]) count += 1;
        }
        return count;
    }
}