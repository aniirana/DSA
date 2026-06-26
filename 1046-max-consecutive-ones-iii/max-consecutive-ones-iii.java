class Solution {
    public int longestOnes(int[] nums, int k) {
        int start=0;
        int end=0;
        int len=0;
        int count=0;
        while(end<nums.length){
            if(nums[end]==0){
                count++;
            }
            while(count>k){
                if(nums[start]==0){
                    count--;
                }
                start++;

            }
            len=Math.max(len,end-start+1);
            end++;
        }
        return len;
        
    }
}