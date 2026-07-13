class Solution {
    public int integerBreak(int n) {
        int[] dp=new int[n+1];
        dp[0]=0;
        dp[1]=1;

        for(int i=2;i<=n;i++){
            dp[i]=Integer.MIN_VALUE;
            for(int j=1;j<i;j++){
                int left=Math.max(j,dp[j]);
                int right=Math.max(i-j,dp[i-j]);
                int ans=left*right;
                dp[i]=Math.max(dp[i],ans);
            }
        }

        return dp[n];
        
    }
}