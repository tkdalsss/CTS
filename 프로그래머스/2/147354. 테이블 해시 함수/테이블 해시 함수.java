import java.util.*;
class Solution {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        int answer = 0;
        
        List<Integer> modList = new ArrayList<>();
        Arrays.sort(data, new Comparator<int[]>(){
            @Override
            public int compare(int[] a, int[] b) {
                if (a[col-1] == b[col-1]) return Integer.compare(b[0], a[0]);
                return Integer.compare(a[col-1], b[col-1]);
            }
        });
        
        // for(int[] d : data) {
        //     System.out.println(Arrays.toString(d));
        // }
        
        for (int i = row_begin; i <= row_end; i++) {
            int tmp = 0;
            for (int j = 0; j < data[0].length; j++) {
                // System.out.println(data[i-1][j] % (i));
                tmp += data[i-1][j] % (i);
            }
            modList.add(tmp);
        }
        
        System.out.println(modList);
        for (int i = 0; i < modList.size(); i++) {
            if (i == 0) {
                answer = modList.get(i);
                continue;
            }
            answer = answer ^ modList.get(i);
        }
        
        return answer;
    }
}