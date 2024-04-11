

public class FindParent {
    static int[] findParent(int[] parent, int x) {
        if (parent[x] != x) findParent(parent, parent[x]);
        return parent[x];
    }

    static void unionParent(int[] parent, int a, int b) {
        a = findParent(parent, a);
        b = findParent(parent, b);
        if (a < b) parent[b] = a;
        else parent[a] = b;
    }

    static int costResult(int[] parent, int[][] edges) {
        int result = 0;
        int last = 0;

        for (int[] edge : edges) {
            int a = edge[0];
            int b = edge[1];
            int cost = edge[2];

            if (findParent(parent, a) != findParent(parent, b)) {
                unionParent(parent, a, b);
                result += cost;
                last = cost;
            }
        }

        return result - last;
    }
}
