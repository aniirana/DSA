class Solution {
    public int[] leftRightDifference(int[] nums) {
        int n=nums.length;
        int[] rightsum=new int[n];
        int[] leftsum=new int[n];

        int sum=0;
        for(int i=0;i<n;i++){
            sum+=nums[i];
        }

        for(int i=0;i<n;i++){
            rightsum[i]=sum-nums[i];
            sum-=nums[i];
        }

        
        for(int i=0;i<n;i++){
            sum+=nums[i];
        }

        for(int i=1;i<n;i++){
           leftsum[0]=0;
           leftsum[i]=leftsum[i-1]+nums[i-1];
        }


        int[] answer=new int[n];
        for(int i=0;i<n;i++){
            answer[i]=Math.abs(leftsum[i]-rightsum[i]);
        }
        return answer;
    }
}