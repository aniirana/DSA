class Solution {
    public int minCost(int n, int[] cuts) {
        //dp[i][j]=dp[i][k]+dp[k][j]+(j-i) ka min 
         Arrays.sort(cuts);
         int m=cuts.length+2;
         int[] arr=new int[m];
         arr[0]=0;
         arr[m-1]=n;
         for (int i = 0; i < cuts.length; i++)
            arr[i + 1] = cuts[i];

        int[][] dp=new int[m][m];
     
        for(int gap=1;gap<m;gap++){
            for(int i=0,j=gap;j<m;i++,j++){

                if (gap == 1) {
                    dp[i][j] = 0;
                    continue;
                }

                int minicut = Integer.MAX_VALUE;

                
                for(int k=i+1;k<j;k++){
                    int cost=dp[i][k]+dp[k][j]+(arr[j]-arr[i]);
                    minicut=Math.min(minicut,cost);
                }
                dp[i][j]=minicut;
            }
        }

        return dp[0][m-1];
    }
}