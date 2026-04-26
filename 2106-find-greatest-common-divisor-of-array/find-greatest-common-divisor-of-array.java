class Solution {
    public int findGCD(int[] nums) {
        Arrays.sort(nums);
        int a=nums[0];
        int b=nums[nums.length-1];
        int gcd=0;
        int ans=0;
        int div=0;
        for(int i=1;i<=b;i++){
            if(a%i==0 && b%i==0){
                 div=i;
            }
            ans=Math.max(gcd,div);
        }
        return ans;
    }
}