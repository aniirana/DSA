class Solution {
    public int findKthPositive(int[] nums, int k) {
        int low=0;
        int n=nums.length;
        int high=n-1;

        while(low<=high){
            int mid=low+(high-low)/2;

            int ans=nums[mid]-(mid+1);

            if(ans<k){
                low=mid+1;
            }else{
                high=mid-1;
            }
        }

        return low+k;
    }

    
}