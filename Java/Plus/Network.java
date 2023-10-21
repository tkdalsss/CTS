package CTS.Java.Plus;

public class Network {
  static int solution(int n, int[][] computers) {
    int answer = 0;
    boolean[] check = new boolean[n];

    for (int i = 0; i < computers.length; i++) {
      if (!check[i]) {
        dfs(i, computers, check);
        answer++;
      }
    }

    return answer;
  }

  static void dfs(int i, int[][] computers, boolean[] check) {
    check[i] = true;
    for (int j = 0; j < computers.length; j++) {
      if (i != j && !check[j] && computers[i][j] == 1) {
        dfs(j, computers, check);
      }
    }
  }
}
