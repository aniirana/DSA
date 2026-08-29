class dsu{
    int[] parent;

    dsu(int n){
        parent =new int[n];
        for(int i=0;i<n;i++){
            parent[i]=i;
        }

    }

    public int findparent(int node){
        if(node==parent[node]){
            return node;
        }

        return parent[node]=findparent(parent[node]);
    }

    public void unionbysize(int u,int v){
        int pu=findparent(u);
        int pv=findparent(v);

        if(pu==pv) return;

        parent[pv]=pu;
    }
}

class Solution {
    class Pair{
        int val;
        int index;
        Pair(int v,int i){
            this.val=v;
            this.index=i;
        }
    }
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        Pair[] arr=new Pair[nums.length];
        for(int i=0;i<nums.length;i++){
            arr[i]=new Pair(nums[i],i);
        }

        Arrays.sort(arr,(a,b)->a.val-b.val);

        dsu ds=new dsu(nums.length);

        for(int i=1;i<nums.length;i++){
            if(arr[i].val-arr[i-1].val<=limit){
                ds.unionbysize(arr[i].index,arr[i-1].index);
            }
        }

        HashMap<Integer,ArrayList<Integer>> map=new HashMap<>();

        for(int i=0;i<nums.length;i++){
            int parent=ds.findparent(i);

            map.putIfAbsent(parent,new ArrayList<>());
            map.get(parent).add(i);
        }

        for(ArrayList<Integer> indices:map.values()){
            Collections.sort(indices);

            ArrayList<Integer> values=new ArrayList<>();

            for(int idx:indices){
                values.add(nums[idx]);

            }

            Collections.sort(values);
            for(int i=0;i<indices.size();i++){
                nums[indices.get(i)]=values.get(i);
            }
        }

        return nums;
    }


}