import java.util.*;

class Solution {

    class Edge {
        int to, cost;

        Edge(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }
    }

    public int findMaxPathScore(int[][] edges, boolean[] online, long k) {

        int n = online.length;

        ArrayList<ArrayList<Edge>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        int[] indegree = new int[n];

        int low = Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];

            graph.get(u).add(new Edge(v, w));
            indegree[v]++;

            low = Math.min(low, w);
            high = Math.max(high, w);
        }

        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }

        ArrayList<Integer> topo = new ArrayList<>();

        while (!q.isEmpty()) {
            int node = q.poll();
            topo.add(node);

            for (Edge edge : graph.get(node)) {
                indegree[edge.to]--;

                if (indegree[edge.to] == 0) {
                    q.offer(edge.to);
                }
            }
        }

        int ans = -1;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (check(mid, graph, topo, online, k, n)) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return ans;
    }

    boolean check(int minEdge,
                  ArrayList<ArrayList<Edge>> graph,
                  ArrayList<Integer> topo,
                  boolean[] online,
                  long k,
                  int n) {

        long[] dist = new long[n];
        Arrays.fill(dist, Long.MAX_VALUE);

        dist[0] = 0;

        for (int u : topo) {

            if (dist[u] == Long.MAX_VALUE) {
                continue;
            }

            if (u != 0 && u != n - 1 && !online[u]) {
                continue;
            }

            for (Edge edge : graph.get(u)) {

                int v = edge.to;
                int w = edge.cost;

                if (w < minEdge) {
                    continue;
                }

                if (v != n - 1 && !online[v]) {
                    continue;
                }

                if (dist[u] + w < dist[v]) {
                    dist[v] = dist[u] + w;
                }
            }
        }

        return dist[n - 1] <= k;
    }
}