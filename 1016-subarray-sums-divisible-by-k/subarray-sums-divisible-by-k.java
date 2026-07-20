class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        HashMap<Integer,Integer> map=new HashMap<>();
        int sum=0;
        map.put(0,1);
        int count=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            int rem=( sum%k + k)%k;

           
                count+=map.getOrDefault(rem,0);
            
            
                map.put(rem,map.getOrDefault(rem,0)+1);
            
        }

        return count;
    }
}