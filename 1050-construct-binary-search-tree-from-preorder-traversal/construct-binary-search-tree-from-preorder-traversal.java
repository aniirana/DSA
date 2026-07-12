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
    int idx=0;
    public TreeNode bstFromPreorder(int[] preorder) {
        return solve(preorder,Integer.MIN_VALUE,Integer.MAX_VALUE);
    }

    public TreeNode solve(int[] preorder,int low,int high){
        int n=preorder.length;
        if(idx==n){
            return null;
        }

        if(preorder[idx]<low || preorder[idx]>high){
            return null;
        }

        TreeNode node=new TreeNode(preorder[idx]);
        idx++;

        node.left=solve(preorder,low,node.val);
        node.right=solve(preorder,node.val,high);

        return node;



        
    }
}