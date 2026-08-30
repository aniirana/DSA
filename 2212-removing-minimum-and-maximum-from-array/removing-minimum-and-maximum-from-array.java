class Solution {
    public int minimumDeletions(int[] nums) {
        int min=0;
        int max=0;
        int n=nums.length;
        for(int i=0;i<n;i++){
            if(nums[i]<nums[min]) min=i;
            if(nums[i]>nums[max]) max=i;
        }

        int left=Math.min(min,max);
        int right=Math.max(min,max);

        int opt1=right+1;
        int opt2=n-left;

        int opt3=(left+1)+(n-right); 

        return Math.min(opt1,Math.min(opt2,opt3));
    }
}