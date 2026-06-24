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
    public int leftheight(TreeNode root){
        int h=0;
        while(root!=null){
            h++;
            root=root.left;
        }
        return h;
    }
    public int rightheight(TreeNode root){
        int h=0;

        while(root!=null){
            h++;
            root=root.right;
        }
        return h;
    
    }
    public int countNodes(TreeNode root) {
        int lh;
        int rh;
        
        if(root==null) return 0;
        
        lh=leftheight(root);
        rh=rightheight(root);
        if(lh==rh){
            return calculateheight(lh);
        }
        
        return 1+countNodes(root.left)+countNodes(root.right);
        
    }

    public int calculateheight(int level){
        
        int height=(1 << level)-1;
        return height;
    }
}