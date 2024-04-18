import java.util.*;
class Solution {
    static String[][] island;
    static int[][] distance;
    static boolean[][] visited;
    public int[] solution(String[] maps) {
        int[] answer = {};
        int n = maps.length;
        int m = maps[0].length();
        
        island = new String[n][m];
        distance = new int[n][m];
        visited = new boolean[n][m];
        
        int[] sp = new int[2];
        boolean flag = false;
        List<Integer> list = new ArrayList<>();
        
        for (int i = 0; i < maps.length; i++) {
            String[] tmp = maps[i].split("");
            for (int j = 0; j < tmp.length; j++) {
                island[i][j] = tmp[j];
                if (!tmp[j].equals("X")) {
                    if(!flag) {
                        flag = true;
                        // System.out.println(i + " " + j);
                        sp[0] = i;
                        sp[1] = j;
                    }
                    distance[i][j] = Integer.parseInt(island[i][j]);
                }
            }
        }
        
        if (island[sp[0]][sp[1]].equals("X")) return new int[]{-1};
        
        list.add(bfs(sp));
        
        for (int i = 0; i < visited.length; i++) {
            for (int j = 0; j < visited[0].length; j++) {
                if (!visited[i][j] && distance[i][j] > 0) {
                    list.add(bfs(new int[]{i, j}));
                }
            }
        }
        
        int[] result = list.stream().mapToInt(Integer::intValue).toArray();
        Arrays.sort(result);
        return result;
    }
    
    static int bfs(int[] startPoint) {
        Queue<int[]> q = new LinkedList<>();
        q.add(startPoint);
        
        visited[startPoint[0]][startPoint[1]] = true;
        distance[startPoint[0]][startPoint[1]] = Integer.parseInt(island[startPoint[0]][startPoint[1]]);
        
        List<Integer> list = new ArrayList<>();
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        int max = 0;
        int endx = startPoint[0];
        int endy = startPoint[1];
        int totalValue = Integer.parseInt(island[startPoint[0]][startPoint[1]]);
        
        while(!q.isEmpty()) {
            int[] point = q.poll();
            int x = point[0];
            int y = point[1];
            
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                if (nx < 0 || ny < 0 || nx >= island.length || ny >= island[0].length || visited[nx][ny]) continue;
                if (island[nx][ny].equals("X")) continue;
                
                visited[nx][ny] = true;
                totalValue += Integer.parseInt(island[nx][ny]);
                
                distance[nx][ny] = totalValue;
                q.add(new int[]{nx, ny});
                endx = nx;
                endy = ny;
            }
        }
        
        return distance[endx][endy];
    }
}