class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int n = nums.length;
        int total = 0;
        for (int i : nums) {
            total += i;
        }
        if (total % k != 0) {
            return false;
        }

        int target = total / k;
        boolean[] used = new boolean[n];
        return solve(0, 0, nums, k, target, used);
    }

    public boolean solve(int i, int sum, int[] nums, int k, int target, boolean[] used) {
        int n = nums.length;
        if(k==1){
            return true;
        }
        if (sum == target) {
            return solve(0, 0, nums, k - 1, target, used);
        }

        for (int j = i; j < n; j++) {
            if (!used[j] && nums[j] + sum <= target) {
                used[j] = true;

                if (solve(j + 1, sum + nums[j], nums, k, target, used)) {
                    return true;
                }

                used[j] = false;
            }

        }
        return false;
    }
}