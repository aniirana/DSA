class Solution {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);

        int count=1;
        
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]==nums[i+1]){
                count++;
            }

            else{
                count=1;
            }

            if(count>(nums.length/2)){
                return nums[i];
            }

        }
        return nums[0];
    }
}