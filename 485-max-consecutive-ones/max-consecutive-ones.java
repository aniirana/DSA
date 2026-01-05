class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int count =0;
        int maxcount=0;
        
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
                count=0;
            }else if(nums[i]==1){
                count++;
            }
            maxcount=Math.max(count,maxcount);
        }

        return maxcount;
        
    }
}