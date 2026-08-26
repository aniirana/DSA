class Solution {
    public int missingMultiple(int[] nums, int k) {
        int n = nums.length;

        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < n; i++) {
            set.add(nums[i]);
        }

        
        
        for(int i=0;i<set.size();i++)
        {
            if(!set.contains(k*(i+1)))
            {
                return (k*(i+1));
            }
        }

        return k*(set.size()+1);
    }
}