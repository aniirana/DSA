class Solution {
    public int findMaxLength(int[] nums) {
        HashMap<Integer,Integer> map=new HashMap<>();
        map.put(0,-1);
        int n=nums.length;
        int sum=0;
        int idx=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            if(nums[i]==0){
                sum=sum-1;
            }
            else{
                sum=sum+1;
            }

            if(map.containsKey(sum)){
                int maxidx=i-map.get(sum);
                idx=Math.max(idx,maxidx);
            }else{
                map.put(sum,i);
            }
        }
        if(idx==Integer.MIN_VALUE){
            return 0;
        }
        return idx;
    }
}