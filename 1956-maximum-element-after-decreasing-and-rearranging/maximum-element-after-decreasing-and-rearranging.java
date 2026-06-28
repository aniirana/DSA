class Solution {
    public int maximumElementAfterDecrementingAndRearranging(int[] nums) {
        Arrays.sort(nums);
        int n=nums.length;
        nums[0]=1;
        for(int i=0;i<n-1;i++){
            if(nums[i+1]>nums[i]){
                nums[i+1]=nums[i]+1;
            }
        }
        return nums[nums.length-1];
        
        
    }
}