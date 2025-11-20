class Solution {
    public int pivotIndex(int[] nums) {
        int n=nums.length;
        int[] arrl=new int[n];
        int[] arrr=new int[n];

        int lsum=0;
        for(int i=0;i<n;i++){
            lsum+=nums[i];
            arrl[i]=lsum;
        }

        int rsum=0;
        
        for(int i=n-1;i>=0;i--){
            rsum+=nums[i];
            arrr[i]=rsum;
        }

        for(int i=0;i<n;i++){
            if(arrl[i]==arrr[i]){
                return i;
            }
        }
        return -1;
    }
}