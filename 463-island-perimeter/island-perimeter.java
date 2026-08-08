class Solution {
    public int islandPerimeter(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        boolean[][] vis=new boolean[m][n];

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    return dfs(i,j,grid,vis);
                }
            }
        }
        return 0;

    }

    public int dfs(int r,int c,int[][] grid,boolean[][] vis){
        int m=grid.length;
        int n=grid[0].length;

        if(r<0 || c<0 || r>=m || c>=n){
            return 1;
        }

        if(grid[r][c]==0){
            return 1;
        }

        if(vis[r][c]){
            return 0;
        }

        vis[r][c]=true;
        int peri=0;
        peri+=dfs(r+1,c,grid,vis);
        peri+=dfs(r-1,c,grid,vis);
        peri+=dfs(r,c+1,grid,vis);
        peri+=dfs(r,c-1,grid,vis);

        return peri;
    }
}