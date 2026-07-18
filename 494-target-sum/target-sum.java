class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int sum=0;
        int n=nums.length;
        for(int i=0;i<n;i++){
            sum+=nums[i];
        }
        int ans=(target+sum)/2;

        return solve(nums,ans,sum,target);
        
    }

    public int solve(int[] nums,int ans,int sum,int target){
       
        int n=nums.length;

        if (Math.abs(target) > sum) return 0;
        if ((target + sum) % 2 != 0) return 0;

        int[] dp=new int[ans+1];
        dp[0]=1;
      
        for(int i=0;i<n;i++){
            for(int j=ans;j>=nums[i];j--){
                dp[j]=dp[j]+dp[j-nums[i]];
            }
        }

        return dp[ans];
    }
}