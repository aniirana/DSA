class Solution {
    public long maxStrength(int[] nums) {
        Arrays.sort(nums);
        int n=nums.length;
        int zerocount=0;
        int negcount=0;

        for(int i=0;i<n;i++){
            if(nums[i]==0) zerocount++;

            if(nums[i]<0) negcount++;
        }

        int skip=-1;
        if(negcount%2==1){
            skip=negcount-1;
        }

        if(n == 1){
           return nums[0];
        }

        long prod=1;
        boolean taken=false;
        for(int i=0;i<n;i++){
            if(nums[i]==0 || i==skip) continue;

            

            prod=prod*nums[i];
            taken=true;
        }
        if(!taken){
            return 0;
        }
        return prod;
    }
}