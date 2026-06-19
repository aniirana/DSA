class Solution {
    public int largestAltitude(int[] nums) {
        int n=nums.length;
        int[] arr=new int[n+1];
        
        int sum=0;
        arr[0] = 0;
        for(int i=0;i<n;i++){
            
            sum+=nums[i];
            arr[i+1]=sum;
            
        }

        int max=arr[0];
        for(int i=0;i<=n;i++){
            if(arr[i]>max){
                max=arr[i];

            }

        }
        return max;
    }
}