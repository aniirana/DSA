class Solution {
    public int longestOnes(int[] nums, int k) {
        int n=nums.length;
        int left=0;
        int size=Integer.MIN_VALUE;
        int count=0;

        for(int right=0;right<n;right++){
            if(nums[right]==0){
                count++;
            }
            while(count>k){
                if(nums[left]==0){
                    count--;
                }
                left++;
            }
            size=Math.max(size,right-left+1);
        }
        return size;
    }
}