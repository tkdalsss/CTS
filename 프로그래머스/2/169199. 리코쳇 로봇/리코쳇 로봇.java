import java.util.*;
class Solution {
    static int n, m;
    static class Point {
        int x, y, depth;
        public Point(int x, int y, int depth) {
            this.x = x;
            this.y = y;
            this.depth = depth;
        }
    }
    public int solution(String[] board) {
        int answer = 0;
        
        n = board.length;
        m = board[0].length();
        
        Point robot = null;
        Point goal = null;
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                char ch = board[i].charAt(j);
                
                if (ch == 'R'){
                    robot = new Point(i, j, 0);
                } else if (ch == 'G') {
                    goal = new Point(i, j, 0);
                }
            }
        }
        
        answer = bfs(board, robot, goal);
        
        return answer;
    }
    static int bfs(String[] board, Point robot, Point goal) {
        Queue<Point> q = new LinkedList<>();
        q.add(robot);
        boolean[][] visited = new boolean[n][m];
        visited[robot.x][robot.y] = true;
        
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, -1, 0, 1};
        
        while(!q.isEmpty()) {
            Point cur = q.poll();
            
            // 이동이 완료된 다음에 goal과의 위치 체크
            if (cur.x == goal.x && cur.y == goal.y) {
                return cur.depth;
            }
            
            for (int i = 0; i < 4; i++) {
                int nx = cur.x;
                int ny = cur.y;
                
                // 벽이 있는 곳까지 계속 이동. 맵 밖으로는 이동 x
                while (nx >= 0 && ny >= 0 && nx < n && ny < m && board[nx].charAt(ny) != 'D') {
                    nx += dx[i];
                    ny += dy[i];
                }
                
                // 한번 빼줘야 함
                nx -= dx[i];
                ny -= dy[i];
                
                if (visited[nx][ny] || (cur.x==nx && cur.y == ny)) continue;
                
                visited[nx][ny] = true;
                q.add(new Point(nx, ny, cur.depth+1));
                
            }
        }
        
        return -1;
    }
}