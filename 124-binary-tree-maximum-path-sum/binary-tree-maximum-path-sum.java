class Solution {
    int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        solve(root);
        return max;
    }

    public int solve(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int lh = Math.max(0, solve(root.left));
        int rh = Math.max(0, solve(root.right));

        max = Math.max(lh + rh + root.val, max);

        return root.val + Math.max(lh, rh);
    }
}