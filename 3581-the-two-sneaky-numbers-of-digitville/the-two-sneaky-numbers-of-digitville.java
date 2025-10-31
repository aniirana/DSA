class Solution {
    public int[] getSneakyNumbers(int[] nums) {
        Arrays.sort(nums);
        int n=nums.length;
        int[] arr=new int[n];
        int j=0;
        for(int i=1;i<n;i++){
            if(nums[i]==nums[i-1]){
                arr[j++]=nums[i];
                
            }

        }
        return Arrays.copyOf(arr, j);
    }
}