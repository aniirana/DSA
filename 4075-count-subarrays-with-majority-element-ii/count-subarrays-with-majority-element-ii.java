class Solution {

    class Fenwick {
        int[] bit;

        Fenwick(int n) {
            bit = new int[n + 2];
        }

        void add(int idx, int val) {
            while (idx < bit.length) {
                bit[idx] += val;
                idx += idx & -idx;
            }
        }

        int sum(int idx) {
            int ans = 0;
            while (idx > 0) {
                ans += bit[idx];
                idx -= idx & -idx;
            }
            return ans;
        }
    }

    public long countMajoritySubarrays(int[] nums, int target) {

        int n = nums.length;

        int[] prefix = new int[n + 1];

        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + (nums[i] == target ? 1 : -1);
        }

        int[] vals = prefix.clone();
        Arrays.sort(vals);

        Map<Integer, Integer> map = new HashMap<>();
        int idx = 1;

        for (int x : vals) {
            if (!map.containsKey(x)) {
                map.put(x, idx++);
            }
        }

        Fenwick bit = new Fenwick(idx + 2);

        long ans = 0;

        for (int x : prefix) {
            int pos = map.get(x);

            ans += bit.sum(pos - 1);

            bit.add(pos, 1);
        }

        return ans;
    }
}