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
    public int minimumOperations(TreeNode root) {
        Queue<TreeNode> queue=new LinkedList<>();

        queue.offer(root);
        int ans=0;
        while(!queue.isEmpty()){
            int size=queue.size();

            int[] arr=new int[size];
            for(int i=0;i<size;i++){
                TreeNode node=queue.poll();
                arr[i]=node.val;
                if(node.left!=null){
                    queue.offer(node.left);
                }
                if(node.right!=null){
                    queue.offer(node.right);
                }
            }

            ans+=minswaps(arr);
        }
        return ans;
    }

    public int minswaps(int[] arr){
        HashMap<Integer,Integer> map=new HashMap<>();
        int n=arr.length;
        for(int i=0;i<n;i++){
            map.put(arr[i],i);
        }
        int swaps=0;
        int[] sorted=arr.clone();
        Arrays.sort(sorted);

        for(int i=0;i<n;i++){
            if(arr[i]==sorted[i]){
                continue;
            }
            swaps++;

            int correctindex=map.get(sorted[i]);

            map.put(arr[i],correctindex);
            map.put(sorted[i],i);

            int temp=arr[i];
            arr[i]=arr[correctindex];
            arr[correctindex]=temp;
        }
        return swaps;
    }
}