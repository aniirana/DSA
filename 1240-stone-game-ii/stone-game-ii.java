class Solution {
    public int stoneGameII(int[] piles) {
        int n=piles.length;
        int[][][] dp=new int[2][n+1][n+1];

        for(int i=0;i<2;i++){
            for(int j=0;j<n+1;j++){
                for(int k=0;k<n+1;k++){
                    dp[i][j][k]=-1;
                }
            }
        }
        
       return solve(1,0,1,piles,dp);
    }

    public int solve(int person,int i,int m,int[] piles,int[][][] dp){
        int n=piles.length;

        if(i>=n){
            return 0;
        }

        if(dp[person][i][m]!= -1){
            return dp[person][i][m];
        }
        int sum=0;
        int res=(person==1)?Integer.MIN_VALUE:Integer.MAX_VALUE;

        

        for(int x=1;x<=Math.min(2*m,n-i);x++){
            sum+=piles[i+x-1];

            if(person==1){
                res=Math.max(res,sum+solve(0,i+x,Math.max(m,x),piles,dp));
            }else{
                res=Math.min(res,solve(1,i+x,Math.max(m,x),piles,dp));
            }
        }

        return dp[person][i][m]=res;

    }
}