class Solution {
    public int minimumCost(int[] nums) {
        int sum=nums[0];
        int n=nums.length;
        int min=Integer.MAX_VALUE;
        int secondmin=Integer.MAX_VALUE;

        for(int i=1;i<nums.length;i++){
            if(min>nums[i]){
                secondmin=min;
                min=nums[i];
            }
            else if(nums[i]<secondmin){
                secondmin=nums[i];
            }
        }
        return sum+min+secondmin;
    }
}