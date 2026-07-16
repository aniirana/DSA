class Solution {
    public long gcdSum(int[] nums) {
        int max=nums[0];
        int n=nums.length;
        int[] mx=new int[n];
        mx[0]=max;
        int[] prefgcd=new int[n];
        prefgcd[0]=gcd(nums[0],mx[0]);
        for(int i=1;i<n;i++){
            if(max<nums[i]){
                max=nums[i];
            }
            mx[i]=max;
            prefgcd[i]=gcd(nums[i],mx[i]);
        }
        Arrays.sort(prefgcd);
        int l=0;
        int r=n-1;
        long sum=0;

        while(l<r){
            sum+=gcd(prefgcd[l],prefgcd[r]);
            l++;
            r--;
        } 

        return sum;
        
    }

    public int gcd(int a,int b){
        if(b==0){
            return a;
        }

        return gcd(b,a%b);
    }
}