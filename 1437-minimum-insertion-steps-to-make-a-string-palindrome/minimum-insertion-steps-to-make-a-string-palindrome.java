class Solution {
    public int minInsertions(String s) {
        String t = new StringBuilder(s).reverse().toString();

        int m = s.length();
        int n = t.length();

        int[][] dp=new int[m+1][n+1];
        
        for(int i=1;i<m+1;i++){
            for(int j=1;j<n+1;j++){
                if(s.charAt(i-1)==t.charAt(j-1)){
                    dp[i][j]=1+dp[i-1][j-1];

                }
                else{
                    dp[i][j]=Math.max(dp[i][j-1],dp[i-1][j]);
                }
            }
        }
        int ans=m-dp[m][n];
        return ans;
    }
}