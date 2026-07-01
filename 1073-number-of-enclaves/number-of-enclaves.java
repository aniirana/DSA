class Solution {
    public int numEnclaves(int[][] grid) {
        //traverse karnege and then jo boundary  mai honge unse connected ko 0 mark kar lena hai and then jo beech mai reh gaye unke liye count nikalna hai 
        int m=grid.length;
        int n=grid[0].length;

        boolean[][] visited=new boolean[m][n]; 
        for(int i=0;i<n;i++){
            if(grid[0][i]==1){
                dfs(grid,visited,0,i);
            }
            if(grid[m-1][i]==1){
                dfs(grid,visited,m-1,i);
            }
        }

        for(int j=0;j<m;j++){
            if(grid[j][0]==1){
                dfs(grid,visited,j,0);

            }
            if(grid[j][n-1]==1){
                dfs(grid,visited,j,n-1);
            }
        }
        int count=0;

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1 && !visited[i][j]){
                    count++;
                }
            }
        }
        return count;

        
    }

    public void dfs(int[][] grid,boolean[][] visited,int r,int c){
        if(r<0 ||r>=grid.length ||c<0 ||c>=grid[0].length || visited[r][c] || grid[r][c]==0){
            return ;
        }

        
        visited[r][c]=true;

        dfs(grid,visited,r-1,c);
        dfs(grid,visited,r+1,c);
        dfs(grid,visited,r,c-1);
        dfs(grid,visited,r,c+1);
    }
}