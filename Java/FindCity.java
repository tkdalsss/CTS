package CTS.Java;

import java.util.*;

public class FindCity {

  // 도시 개수, 도로 개수, 거리 정보, 출발도시번호
  public static int n, m, k, x;
  public static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();

  public static int[] d = new int[300001];

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    n = sc.nextInt();
    m = sc.nextInt();
    k = sc.nextInt();
    x = sc.nextInt();

    // distance 초기화
    for (int i = 0; i <= n; i++) {
      graph.add(new ArrayList<Integer>());
      d[i] = -1;
    }

    // 도로 정보 입력 받기
    for (int i = 0; i < m; i++) {
      int a = sc.nextInt();
      int b = sc.nextInt();
      graph.get(a).add(b);
    }

    // 출발 도시까지 거리 0으로
    d[x] = 0;

    // BFS
    Queue<Integer> q = new LinkedList<Integer>();
    q.offer(x);
    while (!q.isEmpty()) {
      int now = q.poll();
      // 현재 도시에서 이동할 수 있는 모든 도시 확인
      for (int i = 0; i < graph.get(now).size(); i++) {
        int nextNode = graph.get(now).get(i);
        if (d[nextNode] == -1) {
          d[nextNode] = d[now] + 1;
          q.offer(nextNode);
        }
      }
    }

    // 최단 거리가 K인 모든 도시의 번호 오름차순으로 출력
    boolean check = false;
    for (int i = 1; i <= n; i++) {
      if (d[i] == k) {
        System.out.println(i);
        check = true;
      }
    }

    // 만약 최단 거리가 k인 도시가 없다면 -1 출력
    if (!check)
      System.out.println(-1);

    sc.close();

  }

}
