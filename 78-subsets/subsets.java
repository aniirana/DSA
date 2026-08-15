class Solution {
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        solve(nums, 0, new ArrayList<>());

        return ans;
    }

    public void solve(int[] nums, int start, List<Integer> list) {

        ans.add(new ArrayList<>(list));

        for (int i = start; i < nums.length; i++) {
            //add
            list.add(nums[i]);
            //recurse
            solve(nums, i + 1, list);
            //bt
            list.remove(list.size() - 1);
        }
    }
}