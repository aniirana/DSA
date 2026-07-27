class Solution {
    public int minSwaps(int[] nums) {
        int n=nums.length;
        int k=0;
        for(int i=0;i<n;i++){
            if(nums[i]==1){
                k++;
            }

        }

        if(k<=1){
            return 0;
        }
        int i=0;
        int count=0;
        int max=0;

        for(int j=0;j<2*n;j++){
            
            if(nums[j%n]==1){
                count++;
            }
            if(j-i+1>k){
                if(nums[i%n]==1){
                    count--;
                }
                i++;
            }


            if(j-i+1==k){
                max=Math.max(max,count);
               
            }



        }
       return k-max;
        
    }
}