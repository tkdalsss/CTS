package CTS.Java.Plus;

import java.util.*;

public class TravelRoute {
  static boolean[] visited;
  static ArrayList<String> allRoute;

  public String[] solution(String[][] tickets) {
    String[] answer = {};

    int cnt = 0;
    visited = new boolean[tickets.length]; // 목적지 만큼 갯수
    allRoute = new ArrayList<>(); // route들 저장

    dfs("ICN", "ICN", tickets, cnt);

    Collections.sort(allRoute);
    answer = allRoute.get(0).split(" ");

    return answer;
  }

  static void dfs(String start, String route, String[][] tickets, int cnt) {
    if (cnt == tickets.length) {
      allRoute.add(route);
      return;
    }
    for (int i = 0; i < tickets.length; i++) {
      if (start.equals(tickets[i][0]) && !visited[i]) {
        visited[i] = true;
        dfs(tickets[i][1], route + " " + tickets[i][1], tickets, cnt + 1);
        visited[i] = false;
      }
    }
  }
}
