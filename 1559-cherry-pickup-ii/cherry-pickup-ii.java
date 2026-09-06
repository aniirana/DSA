class Solution {
    public int cherryPickup(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int[][][] dp = new int[n][m][m];

        for (int[][] arr : dp) {
            for (int[] row : arr) {
                Arrays.fill(row, -1);
            }
        }

        return solve(0, 0, m - 1, dp, grid);
    }

    public int solve(int r,int c1,int c2,int[][][] dp,int[][] grid){
        int n=grid.length;
        int m=grid[0].length;

        if(c1<0 || c1>=m || c2<0 || c2>=m){
            return Integer.MIN_VALUE;
        }

        if(r==n-1){
            if(c1==c2){
                return grid[r][c1];
            }else {
                return grid[r][c1] + grid[r][c2];
            }
        }

        if(dp[r][c1][c2]!=-1){
            return dp[r][c1][c2];
        }

        int cherries=0;
        int max=Integer.MIN_VALUE;
        if(c1==c2){
            cherries=grid[r][c1];
        }else{
            cherries=grid[r][c1]+grid[r][c2];
        }
        
        for(int j=-1;j<=1;j++){
    
            for(int k=-1;k<=1;k++){

             int next=solve(r+1,c1+j,c2+k,dp,grid);
             max=Math.max(max,next);

            }
            
        }
        return dp[r][c1][c2]=cherries+max;
    }
}