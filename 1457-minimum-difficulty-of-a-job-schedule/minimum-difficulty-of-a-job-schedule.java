class Solution {
    public int minDifficulty(int[] jobDifficulty, int d) {
        int n=jobDifficulty.length;
        int[][] dp=new int[n+1][d+1];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        dp[0][0]=0;
        for(int p=1;p<=d;p++){
            for(int i=p;i<=n;i++){

                dp[i][p]=Integer.MAX_VALUE;
                int right=0;

                for(int j=i;j>=p;j--){
                    right=Math.max(right,jobDifficulty[j-1]);
                    if(dp[j-1][p-1]!=Integer.MAX_VALUE){
                        dp[i][p]=Math.min(dp[i][p],dp[j-1][p-1]+right);
                    }
                }
            }
        }
        return dp[n][d]==Integer.MAX_VALUE?-1:dp[n][d];
    }
}