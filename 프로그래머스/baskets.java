class Solution {
    static int EMPTY_SPACE = 0;
   static int RED_START = 1;
   static int BLUE_START = 2;
   static int RED_END = 3;
   static int BLUE_END = 4;
   static int WALL = 5;
   static int[] dx = new int[] {-1,1,0,0};
   static int[] dy = new int[] {0,0,-1,1};
   static int[] originRedPos = new int[2];
   static int[] originBluePos = new int[2];
   static int[] redEndPos = new int[2];
   static int[] blueEndPos = new int[2];
   static int count = Integer.MAX_VALUE;
   static boolean[][] redVisited;
   static boolean[][] blueVisited;
   static int[][] arr;
   public int solution(int[][] maze) {
       int answer = 0;

       arr = maze;
       // red 먼저 시작, blue 먼저 시작
       for (int i = 0; i < maze.length; i++) {
           for (int j = 0; j < maze[i].length; j++) {
               if (maze[i][j] == RED_START) {
                   originRedPos[0] = i;
                   originRedPos[1] = j;
               } else if (maze[i][j] == BLUE_START) {
                   originBluePos[0] = i;
                   originBluePos[1] = j;
               } else if (maze[i][j] == RED_END) {
                   redEndPos[0] = i;
                   redEndPos[1] = j;
               } else if (maze[i][j] == BLUE_END) {
                   blueEndPos[0] = i;
                   blueEndPos[1] = j;
               }
           }
       }
       redVisited = new boolean[maze.length][maze[0].length];
       blueVisited = new boolean[maze.length][maze[0].length];
       redVisited[originRedPos[0]][originRedPos[1]] = true;
       blueVisited[originBluePos[0]][originBluePos[1]] = true;
       dfs(originRedPos[1], originRedPos[0], originBluePos[1], originBluePos[0], 0);
       if (count == Integer.MAX_VALUE) count = 0;
       return count;
   }


       public static void dfs(int redX, int redY, int blueX, int blueY, int round) {
       if (redY == redEndPos[0] && redX == redEndPos[1] && blueY == blueEndPos[0] && blueX == blueEndPos[1]) {
           count = Math.min(round, count);
           return;
       }
       for (int i = 0; i < 4; i++) {
           for (int j = 0; j < 4; j++) {
               int[] newRedPos = new int[2];
               int[] newBluePos = new int[2];
               boolean skipRedCheck = false;
               boolean skipBlueCheck = false;
               // 새로운 이동 지점 선택
               if (redY == redEndPos[0] && redX == redEndPos[1]) {
                   newRedPos[0] = redY;
                   newRedPos[1] = redX;
                   skipRedCheck = true;
               } else {
                   newRedPos[0] = redY + dy[i];
                   newRedPos[1] = redX + dx[i];
               }
               if (blueY == blueEndPos[0] && blueX == blueEndPos[1]) {
                   newBluePos[0] = blueY;
                   newBluePos[1] = blueX;
                   skipBlueCheck = true;
               } else {
                   newBluePos[0] = blueY + dy[j];
                   newBluePos[1] = blueX + dx[j];
               }

                // 이동 가능 여부 체크
               if (newRedPos[0] < 0 || newRedPos[1] < 0 || newBluePos[0] < 0 || newBluePos[1] < 0
               || newRedPos[0] >= arr.length || newRedPos[1] >= arr[0].length || newBluePos[0] >= arr.length || newBluePos[1] >= arr[0].length) continue;

               if (arr[newRedPos[0]][newRedPos[1]] == WALL || arr[newBluePos[0]][newBluePos[1]] == WALL) continue;

               // 이미 도착한 경우 움직이지 않게되므로 중복체크 하지 않음
               if (!skipRedCheck) {
                   if (redVisited[newRedPos[0]][newRedPos[1]]) continue;
               }
               if (!skipBlueCheck) {
                   if (blueVisited[newBluePos[0]][newBluePos[1]]) continue;
               }

               // 수레가 같은 곳으로 이동하려는 경우
               if (newRedPos[0] == newBluePos[0] && newRedPos[1] == newBluePos[1]) continue;
               if (newRedPos[0] == blueY && newRedPos[1] == blueX && newBluePos[0] == redY && newBluePos[1] == redX) continue;
               // 이동 및 round 추가
               redVisited[newRedPos[0]][newRedPos[1]] = true;
               blueVisited[newBluePos[0]][newBluePos[1]] = true;
               dfs(newRedPos[1], newRedPos[0], newBluePos[1], newBluePos[0], round + 1);
               redVisited[newRedPos[0]][newRedPos[1]] = false;
               blueVisited[newBluePos[0]][newBluePos[1]] = false;
           }
       }
   }
}
// import java.util.*;
// class Solution {
//     public int solution(int[][] maze) {
//         int answer = 0;
//         // visited 맵? 생성
//         int n = maze.length;
//         int m = maze[0].length;
//         int[][] visited = new int[n][m];
//         int[][] dist = new int[n][m];
//         int fx = 0;
//         int fy = 0;
//         Queue<int[]> baskets = new LinkedList<>();

//         for (int i = 0; i < n; i++) {
//             Arrays.fill(dist[i], 0);
//             for (int j = 0; j < m; j++) {
//                 if (maze[i][j] != 0) {
//                     visited[i][j] = maze[i][j];
//                     if (maze[i][j] == 1 || maze[i][j] == 2) {
// //                        System.out.println(maze[i][j]);
//                         baskets.add(new int[]{maze[i][j], i, j});
//                     }
//                     if (maze[i][j] == 4) {
//                         fx = i;
//                         fy = j;
//                     }
//                 }
//             }
//         }

//         while (!baskets.isEmpty()) {
//             int[] tmp1 = baskets.poll(); // 빨강 or 파랑, i, j
//             int[] tmp2 = baskets.poll();
// //            System.out.println(Arrays.toString(tmp1));
// //            System.out.println(Arrays.toString(tmp2));
// //            System.out.println(tmp2[1]);
            
//             int x1 = tmp1[1];
//             int y1 = tmp1[2];
//             int x2 = tmp2[1];
//             int y2 = tmp2[2];
//             int t1 = tmp1[0];
//             int t2 = tmp2[0];
            
//             int nx1=0, ny1=0;
//             int nx2=0, ny2=0;

//             int[] dx = {-1, 1, 0, 0};
//             int[] dy = {0, 0, -1, 1};

//             for (int i = 0; i < 4; i++) {
//                 nx1 = x1 + dx[i];
//                 ny1 = y1 + dy[i];
                
//                 // 맵 밖이거나 벽일 경우, 이미 간 경로일 경우가 아니면 break
//                 if (nx1 >= 0 && ny1 >= 0 && nx1 < n && ny1 < m && visited[nx1][ny1] != 5 && visited[nx1][ny1] == 0) break;
//             }
            
//             for (int i = 0; i < 4; i++) {
//                 nx2 = x2 + dx[i];
//                 ny2 = y2 + dy[i];
                
//                 if (nx2 >= 0 && ny2 >= 0 && nx2 < n && ny2 < m && visited[nx2][ny2] != 5 && visited[nx2][ny2] == 0) {
//                     if(nx1 == nx2 && nx2 == ny2) continue;
//                     else break;
//                 }
//             }
            
//             visited[nx1][ny1] = t1;
//             visited[nx2][ny2] = t2;
            
//             baskets.add(new int[]{t1, nx1, ny1});
//             baskets.add(new int[]{t2, nx2, ny2});
            
//             dist[nx1][ny1] = dist[x1][y1] + 1;
//             dist[nx2][ny2] = dist[x2][y2] + 1;
            
//             // if (nx1 == nx2 || ny1 == ny2) {
//             //     q.add(new int[]{t1, x1, y1});
//             //     q.add(new int[]{t2, x2, y2});
//             //     // 
//             //     // visited[]
//             // }
//         }

//         answer = dist[fx][fy];

//         return answer;
//     }
// }