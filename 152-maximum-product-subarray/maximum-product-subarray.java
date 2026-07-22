class Solution {
    public int maxProduct(int[] nums) {
        int n=nums.length;
        int[] min=new int[n+1];
        int[] max=new int[n+1];

        min[n]=1;
        max[n]=1;
        int ans=Integer.MIN_VALUE;
        for(int i=n-1;i>=0;i--){
            max[i]=Math.max(Math.max(nums[i],nums[i]*max[i+1]),nums[i]*min[i+1]);

            min[i]=Math.min(Math.min(nums[i],nums[i]*min[i+1]),nums[i]*max[i+1]);

            ans=Math.max(ans,max[i]);
        }
        
        return ans;
    }
}