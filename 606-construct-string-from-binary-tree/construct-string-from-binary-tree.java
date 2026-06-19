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
    public String stri(TreeNode node,String str){
        if(node==null){
            return str;
        }
        
        str+=node.val;
        
        if(node.left==null && node.right==null){
            return str;
        }
       
        str+="(";
        str=stri(node.left,str);
        str+=")";
        

        if(node.right!=null){
            str+="(";
            str=stri(node.right,str);
            str+=")";
        }

        return str;
    }
    public String tree2str(TreeNode root) {
       return stri(root,"");
    }
}