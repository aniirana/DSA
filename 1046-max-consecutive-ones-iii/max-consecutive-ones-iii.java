class Solution {
    public int longestOnes(int[] nums, int k) {
        int start=0;
        int end=0;
        int count=0;
        int n=nums.length;
        int maxlen=Integer.MIN_VALUE;
        while(end<n){
            if(nums[end]==0){
                count++;
            }

            while(count>k){
                if(nums[start]==0){
                    count--;
                }
                start++;
                
            }

            end++;

            maxlen=Math.max(maxlen,end-start);
        }

        return maxlen;
    }
}