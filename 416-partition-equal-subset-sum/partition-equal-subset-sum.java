class Solution {
    public boolean canPartition(int[] nums) {
        int sum=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
        }
        if(sum%2!=0){
            return false;
        }
        else {
            return subsetsum(nums,sum/2);
        }
        
    }

    public boolean subsetsum(int[] nums,int sum){
        boolean[][] t = new boolean[nums.length+1][sum+1];
        
        for(int i=0;i<nums.length+1;i++){
            for(int j=0;j<=sum;j++){
                if(i==0){
                    t[i][j]=false;
                }
                else if(j==0){
                    t[i][j]=true;
                }
                else if(nums[i-1]<=j){
                    t[i][j]=(t[i-1][j-nums[i-1]] || t[i-1][j]);
                }
                else if(nums[i-1]>j){
                    t[i][j]=t[i-1][j];
                }
                
            }
        }

        return t[nums.length][sum];

    }
}