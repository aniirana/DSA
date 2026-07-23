class Solution {
    public long minimumReplacement(int[] nums) {
        long count=0;
        int parts=0;
        int n=nums.length;
        int prev=nums[n-1];
        
        for(int i=n-2;i>=0;i--){
            if(nums[i]<=prev){
                prev=nums[i];
                continue;
            }
            parts=nums[i]/prev;

            if(nums[i]%prev !=0){
                parts+=1;
            }
            
            

            prev=nums[i]/parts;
            count+=parts-1;
            
        }
        
        return count;
    }
}