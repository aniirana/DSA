class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;

        int[] color = new int[n];
        Arrays.fill(color, -1);

        for (int i = 0; i < n; i++) {

            // Start DFS from every unvisited component
            if (color[i] == -1) {

                if (!dfs(i, 0, color, graph)) {
                    return false;
                }
            }
        }

        return true;
    }

    public boolean dfs(int node, int col, int[] color, int[][] graph) {

        // If already colored, it must match the expected color
        if (color[node] != -1) {
            return color[node] == col;
        }

        // Assign color
        color[node] = col;

        // Color all neighbors with the opposite color
        for (int neigh : graph[node]) {

            if (!dfs(neigh, 1 - col, color, graph)) {
                return false;
            }
        }

        return true;
    }
}