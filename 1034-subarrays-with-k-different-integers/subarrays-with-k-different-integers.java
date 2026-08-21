class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        if (k == 0)
            return 0;
        return atmost(nums, k) - atmost(nums, k - 1);

    }

    public int atmost(int[] nums, int k) {
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();

        int left = 0;
        int i = 0;
        int ans = 0;
        for (i = 0; i < n; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            while (map.size() > k) {
                map.put(nums[left], map.getOrDefault(nums[left], 0) - 1);
                if (map.get(nums[left]) == 0) {
                    map.remove(nums[left]);
                }
                left++;
            }
            ans += i - left + 1;
        }

        return ans;
    }
}