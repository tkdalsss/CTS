import java.util.*;
class Solution {
    static HashMap<Integer, Integer> map = new HashMap<>();
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        
        for (int t : tangerine) {
            map.put(t, map.getOrDefault(t, 0) + 1);
        }
        
        List<Integer> keyList = new ArrayList<>(map.keySet());
        Collections.sort(keyList, new Comparator<Integer>(){
            @Override
            public int compare(Integer a, Integer b) {
                return map.get(b).compareTo(map.get(a));
            }
        });
        
        for (Integer i : keyList) {
            if (k <= 0) break;
            answer++;
            k -= map.get(i);
        }
        
        return answer;
    }
}