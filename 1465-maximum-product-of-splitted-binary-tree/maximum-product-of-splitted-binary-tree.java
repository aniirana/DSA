/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    private static final int MOD = 1_000_000_007;
    long totalSum = 0;
    long maxProduct = 0;

    public int maxProduct(TreeNode root) {
        // Step 1: calculate total sum
        totalSum = treeSum(root);

        // Step 2: compute max product
        subtreeSum(root);

        return (int)(maxProduct % MOD);
    }

    // DFS to compute total sum
    private long treeSum(TreeNode node) {
        if (node == null) return 0;
        return node.val + treeSum(node.left) + treeSum(node.right);
    }

    // DFS to compute subtree sums and max product
    private long subtreeSum(TreeNode node) {
        if (node == null) return 0;

        long left = subtreeSum(node.left);
        long right = subtreeSum(node.right);

        long subSum = node.val + left + right;

        // try cutting here
        long product = subSum * (totalSum - subSum);
        maxProduct = Math.max(maxProduct, product);

        return subSum;
    }
}
