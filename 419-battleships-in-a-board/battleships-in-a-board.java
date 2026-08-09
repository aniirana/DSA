class Solution {
    public int countBattleships(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        int count = 0;

        boolean[][] vis = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'X' && !vis[i][j]) {
                    count++;
                    dfs(i, j, board, vis);
                }
            }
        }
        return count;
    }

    public void dfs(int r, int c, char[][] board, boolean[][] vis) {
        int m = board.length;
        int n = board[0].length;

        if (r < 0 || r >= m || c < 0 || c >= n || board[r][c] != 'X' || vis[r][c]) {
            return;
        }

        vis[r][c] = true;

        dfs(r + 1, c, board, vis);
        dfs(r - 1, c, board, vis);
        dfs(r, c + 1, board, vis);
        dfs(r, c - 1, board, vis);

    }

}