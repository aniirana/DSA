class Solution {
    public int totalFruit(int[] nums) {
        HashMap<Integer,Integer> map=new HashMap<>();

        
        int ans=Integer.MIN_VALUE;
        int left=0;

        for(int i=0;i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);

            while(map.size()>2){
                map.put(nums[left],map.get(nums[left])-1);

                if(map.get(nums[left])==0){
                    map.remove(nums[left]);
                    
                }
                left++;
            }
            
            ans=Math.max(ans,i-left+1);
        }
        return ans;
    }
}