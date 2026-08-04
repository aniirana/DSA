class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        int n=nums.length;
        List<Integer> ans=new ArrayList<>();
        Arrays.sort(nums);
        for(int i = 1; i < nums.length; i++) {
            int prev = nums[i - 1];
            int curr = nums[i];

            for(int num = prev + 1; num < curr; num++) {
                ans.add(num);
            }
        }
        return ans;
    }
}