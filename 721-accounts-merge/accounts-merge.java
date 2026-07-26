class Disjoint{
    int[] parent;
    int[] size;
    public Disjoint(int n){
        parent=new int[n];
        size=new int[n];

        for(int i=0;i<n;i++){
            parent[i]=i;
            size[i]=1;
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

        if(size[pu]<size[pv]){
            parent[pu]=pv;
            size[pv]+=size[pu];
        }else{
            parent[pv]=pu;
            size[pu]+=size[pv];
        }
    }
}


class Solution {
    public List<List<String>> accountsMerge(List<List<String>> details) {
        int n=details.size();
        Disjoint ds=new Disjoint(n);
        HashMap<String,Integer> map=new HashMap<>();

        for(int i=0;i<n;i++){
            for(int j=1;j<details.get(i).size();j++){
                String mail=details.get(i).get(j);
                if(!map.containsKey(mail)){
                    map.put(mail,i);
                }else{
                    ds.unionbysize(i,map.get(mail));
                }
            }
        }

        ArrayList<String>[] merge = new ArrayList[n];
        for(int i=0;i<n;i++){
            merge[i]=new ArrayList<>();
        }

// Put every mail into its parent component
        for(Map.Entry<String,Integer> entry: map.entrySet()){
            String mail = entry.getKey();
            int parent = ds.findparent(entry.getValue());
            merge[parent].add(mail);
        }

// Build answer
        List<List<String>> ans = new ArrayList<>();

    for(int i=0;i<n;i++){
        if(merge[i].size()==0) continue;

        Collections.sort(merge[i]);

        List<String> temp = new ArrayList<>();
        temp.add(details.get(i).get(0));

        for(String mail: merge[i]){
            temp.add(mail);
        }

        ans.add(temp);
    }

    return ans;
        }
    }
