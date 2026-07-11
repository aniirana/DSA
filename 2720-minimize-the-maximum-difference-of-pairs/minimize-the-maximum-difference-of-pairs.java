class Solution {
    public int minimizeMax(int[] nums, int p) {
        int n=nums.length;
        int[] diff=new int[n];
        Arrays.sort(nums);
        int low=0;
        int high=nums[n-1]-nums[0];

        int ans=0;
        while(low<=high){
            int mid=low+(high-low)/2;

            if(make(nums,mid,p)){
                ans=mid;
                high=mid-1;
            }else{
                low=mid+1;
            }
        }

        return ans;
    }

    public boolean make(int[] nums,int mid,int p){
        int count=0;

        int i=0;
        while(i<nums.length-1){
            if(nums[i+1]-nums[i]<=mid){
                count++;
                i+=2;
            }
            else{
                i++;
            }
        }

        if(count>=p){
            return true;

        }
        else{
            return false;
        }
    }
}