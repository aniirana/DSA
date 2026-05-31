class Solution {
    public int minElement(int[] nums) {
        int[] arr=new int[nums.length];
        
        for(int i=0;i<nums.length;i++){
            arr[i]=sumofdig(nums[i]);
        }
        Arrays.sort(arr);

        return arr[0];

        
    }
    public int sumofdig(int n){
        int sum=0;
        while(n!=0){
            int digit=n%10;
            sum+=digit;
            n=n/10;
        }

        return sum;
        
    }
}
