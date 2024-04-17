import java.util.*;
class Solution {
    static String[][] MIRO;
    // static int[][] distance;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    
    public int solution(String[] maps) {
        MIRO = new String[maps.length][maps[0].length()];
        // distance = new int[maps.length][maps[0].length()];
        
        int answer = 0;
        int[] start = new int[2];
        int[] labor = new int[2];
        int[] end = new int[2];
        
        for (int i = 0; i < maps.length; i++) {
            // Arrays.fill(distance[i], 0);
            String[] tmp = maps[i].split("");
            // System.out.println(Arrays.toString(tmp));
            for (int j = 0; j < tmp.length; j++) {
                // System.out.println(tmp[j]);
                if (tmp[j].equals("S")) {
                    // System.out.println(i + " " + j);
                    start[0] = i;
                    start[1] = j;
                }
                if (tmp[j].equals("L")) {
                    labor[0] = i;
                    labor[1] = j;
                }
                if (tmp[j].equals("E")) {
                    end[0] = i;
                    end[1] = j;
                }
                MIRO[i][j] = tmp[j];
            }
        }
        // System.out.println(start);
        
        // System.out.println(Arrays.toString(start));
        int bfs1 = bfs(start, labor);
        int bfs2 = bfs(labor, end);
        
        if (bfs1 == 0 || bfs2 == 0) return -1;
        
        return bfs1 + bfs2;
    }
    static int bfs(int[] start, int[] end) {
        Queue<int[]> q = new LinkedList<>();
        q.add(start);
        // System.out.println(q);
        
        boolean[][] visited = new boolean[MIRO.length][MIRO[0].length];
        int[][] distance = new int[MIRO.length][MIRO[0].length];
        
        while (!q.isEmpty()) {
            int[] p = q.poll();
            int x = p[0];
            int y = p[1];
            // System.out.println(x + " " + y);
            
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                if (nx < 0 || ny < 0 || nx >= MIRO.length || ny >= MIRO[0].length || visited[nx][ny]) continue;
                
                if (MIRO[nx][ny].equals("X")) continue;
                
                visited[nx][ny] = true;
                distance[nx][ny] = distance[x][y] + 1;
                q.add(new int[]{nx, ny});
            }
        }
        // System.out.println(distance[end[0]][end[1]]);
        return distance[end[0]][end[1]];
    }
}