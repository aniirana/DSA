class Solution {
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int count = 0;
        int n = nums.length;

        for (int i = n - 1; i >= 2; i--) {
            int a = 0, b = i - 1;

            while (a < b) {
                if (nums[a] + nums[b] > nums[i]) {
                    count += (b - a);
                    b -= 1;
                } else {
                    a += 1;
                }
            }
        }

        return count;
    }
}