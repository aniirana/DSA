class Solution {
    public int[] validSequence(String word1, String word2) {
        int m=word1.length();
        int n=word2.length();
        int[] dp=new int[m+1];

        int[] ans=new int[n];

        for(int i=m-1;i>=0;i--){
            if(dp[i+1]<n && word1.charAt(i)==word2.charAt(n-dp[i+1]-1)){
                dp[i]=dp[i+1]+1;

            }
            else{
                dp[i]=dp[i+1];
            }
        }

        boolean used=false;
        int j=0;
        for(int i=0;i<m && j<n;i++){
            if(word1.charAt(i)==word2.charAt(j)){
                ans[j]=i;
                j++;
                
            }
            else if(!used && dp[i+1]>=n-j-1){
                ans[j]=i;
                j++;
                used=true;
            }

            
        }

        if (j < n) {
            return new int[0];
        }
        return ans;
    }
}