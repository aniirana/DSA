class Solution {
    public String longestPalindrome(String s) {
        int n=s.length();
        boolean[][] dp=new boolean[n+1][n+1];
        int start=0;
        int maxlen=1;

        for(int gap=0;gap<n;gap++){
            for(int i=0,j=gap;j<n;i++,j++){
                if(gap==0){
                    dp[i][j]=true;
                }
                else if(gap==1){
                    dp[i][j]=(s.charAt(i)==s.charAt(j));
                        
                    
                }else{
                    dp[i][j]=(s.charAt(i)==s.charAt(j) && dp[i+1][j-1]);
                }

                if(dp[i][j] && gap+1>maxlen){
                    start=i;
                    maxlen=gap+1;
                }
            }
        }

        return s.substring(start,start+maxlen);
        
    }
}