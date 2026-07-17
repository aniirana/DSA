class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        
        int n=arr.length;
        int[] dp=new int[n+1];
        for(int i=n-1;i>=0;i--){
            int max=0;
            int curr=-1;
            
            for(int j=i;j<Math.min(n,i+k);j++){
                max=Math.max(max,arr[j]);
                curr=Math.max((j-i+1)*max+dp[j+1],curr);
                dp[i]=curr;
            }
        }
        return dp[0];
    }
}