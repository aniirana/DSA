class Solution {
    public boolean stoneGame(int[] piles) {
        int n=piles.length;
        int[][] dp=new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                dp[i][j]=-1;
            }
        }

        return solve(dp,0,n-1,piles) > 0;
    }

    public int solve(int[][] dp,int i,int j,int[] piles){
        if(i==j){
            return piles[i];
        }

        if(dp[i][j]!=-1){
            return dp[i][j];
        }

        int left=piles[i]-solve(dp,i+1,j,piles);
        int right=piles[j]-solve(dp,i,j-1,piles);

        return dp[i][j]=Math.max(left,right);
    }
}