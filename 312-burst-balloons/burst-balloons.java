class Solution {
    public int maxCoins(int[] nums) {
        int[] arr=new int[nums.length+2];
        arr[0]=1;
        int n=arr.length;
        for(int i=1;i<n-1;i++){
            arr[i]=nums[i-1];
        }
        arr[n-1]=1;

        int[][] dp=new int[n][n];
        for(int gap=0;gap<nums.length;gap++){
            for(int i=1,j=i+gap;j<=nums.length;i++,j++){
                if(gap==0){

                }
                dp[i][j]=Integer.MIN_VALUE;
                
                for(int k=i;k<j+1;k++){
                    int left=0;
                    int right=0;
                    if(k!=i){
                        left=dp[i][k-1];
                    }if(k!=j){
                        right=dp[k+1][j];
                    }
                    dp[i][j]=Math.max(dp[i][j],left+right+arr[i-1]*arr[k]*arr[j+1]);
                    

                }
            }
        }

        return dp[1][nums.length];
    }

    
}