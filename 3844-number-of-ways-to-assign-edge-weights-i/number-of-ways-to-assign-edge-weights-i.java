import java.util.*;

class Solution {
    static final int MOD = 1_000_000_007;

    public int assignEdgeWeights(int[][] edges) {
        int n = edges.length + 1;

        // Build adjacency list
        List<Integer>[] graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            graph[u].add(v);
            graph[v].add(u);
        }

        // BFS to find maximum depth
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n + 1];

        queue.offer(1);
        visited[1] = true;

        int depth = -1;

        while (!queue.isEmpty()) {
            int size = queue.size();
            depth++;

            for (int i = 0; i < size; i++) {
                int node = queue.poll();

                for (int neighbor : graph[node]) {
                    if (!visited[neighbor]) {
                        visited[neighbor] = true;
                        queue.offer(neighbor);
                    }
                }
            }
        }

        // Answer = 2^(depth - 1) mod MOD
        long ans = 1;
        long base = 2;
        int power = depth - 1;

        while (power > 0) {
            if ((power & 1) == 1) {
                ans = (ans * base) % MOD;
            }

            base = (base * base) % MOD;
            power >>= 1;
        }

        return (int) ans;
    }
}