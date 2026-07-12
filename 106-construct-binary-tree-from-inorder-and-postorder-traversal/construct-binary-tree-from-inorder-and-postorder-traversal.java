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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        HashMap<Integer,Integer> map=new HashMap<>();

        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }

        return solve(postorder,0,postorder.length-1,inorder,0,inorder.length-1,map);
        
    }

    public TreeNode solve(int[] postorder,int postart,int postend,int[] inorder,int instart,int inend,HashMap<Integer,Integer> map){

        if(postart>postend || instart>inend){
            return null;
        }

        TreeNode node=new TreeNode(postorder[postend]);

        int inode=map.get(node.val);
        int inlen=inode-instart;

        node.left=solve(postorder,postart,postart+inlen-1,inorder,instart,inode-1,map);

        node.right=solve(postorder,postart+inlen,postend-1,inorder,inode+1,inend,map);

        return node;

    }
}