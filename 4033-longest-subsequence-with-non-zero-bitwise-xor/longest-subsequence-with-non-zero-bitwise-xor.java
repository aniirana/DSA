class Solution {
    public int longestSubsequence(int[] nums) {
        int xor=0;
        int zc=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
                zc++;
            }
            xor^=nums[i];

            
        }

        if(xor!=0) return nums.length;
        if(zc==nums.length) return 0;

        return nums.length-1;
    }
}