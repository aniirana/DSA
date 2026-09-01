class Solution {
    List<List<Integer>> ans=new ArrayList<>();
    public List<List<Integer>> combinationSum3(int k, int n) {
        solve(1,k,n,new ArrayList<>());
        return ans;

    }

    public void solve(int dig,int k,int n,List<Integer> list){
        if(n==0 && k==0){
            ans.add(new ArrayList<>(list));
            return ;
        }

        if(n<0){
            return;
        }

        

        for(int i=dig;i<=9;i++){
            
            if(i>n){
                break;
            }
            //add
            list.add(i);
            //recurse
            solve(i+1,k-1,n-i,list);
            //bt
            list.remove(list.size()-1);
        }
    }
}