class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        boolean[][] vis=new boolean[m][n];

        int max=Integer.MIN_VALUE;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(!vis[i][j] && grid[i][j]==1){
                    max=Math.max(max,dfs(i,j,grid,vis));
                }
            }
        }

        return max==Integer.MIN_VALUE?0:max;
        
    }

    public int dfs(int r,int c,int[][] grid,boolean[][] vis){
        int m=grid.length;
        int n=grid[0].length;
        int count=1;
        if(r<0 || r>=m || c<0 || c>=n || vis[r][c] || grid[r][c]==0){
            return 0;
        }

        vis[r][c]=true;
        
        count+=dfs(r+1,c,grid,vis);
        count+=dfs(r-1,c,grid,vis);
        count+=dfs(r,c-1,grid,vis);
        count+=dfs(r,c+1,grid,vis);

        return count;
    }
}