class Solution {
    int ans = Integer.MAX_VALUE;

    public int minScore(int n, int[][] roads) {

        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();

        for (int i = 0; i <= n; i++)
            adj.add(new ArrayList<>());

        for (int[] road : roads) {
            int u = road[0];
            int v = road[1];
            int wt = road[2];

            adj.get(u).add(new int[]{v, wt});
            adj.get(v).add(new int[]{u, wt});
        }

        boolean[] vis = new boolean[n + 1];

        dfs(1, adj, vis);

        return ans;
    }

    void dfs(int node, ArrayList<ArrayList<int[]>> adj, boolean[] vis) {

        vis[node] = true;

        for (int[] edge : adj.get(node)) {

            int next = edge[0];
            int wt = edge[1];

            ans = Math.min(ans, wt);

            if (!vis[next]) {
                dfs(next, adj, vis);
            }
        }
    }
}