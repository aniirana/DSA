/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if(node==null){
            return node;
        }

        HashMap<Node,Node> visited=new HashMap<>();

        Queue<Node> q=new LinkedList<>();
        visited.put(node,new Node(node.val,new ArrayList<>()));
        q.add(node);

        while(!q.isEmpty()){
            Node n=q.remove();
            for(Node neigh:n.neighbors){
                if(!visited.containsKey(neigh)){
                    visited.put(neigh,new Node(neigh.val,new ArrayList<>()));
                    q.add(neigh);
                }
                visited.get(n).neighbors.add(visited.get(neigh));
            }
        }
        return visited.get(node);
    }
}