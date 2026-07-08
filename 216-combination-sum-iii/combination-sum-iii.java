class Solution {
    List<List<Integer>> ans=new ArrayList<>();
    public List<List<Integer>> combinationSum3(int k, int n) {

        solve(1,k,n,new ArrayList<>());
        return ans;
    }

    public void solve(int start,int k,int target,List<Integer> list){
        if(k==0){
            if(target==0){
                ans.add(new ArrayList<>(list));
                return ;
            }
        }

        if(target<0){
            return;
        }

        for(int i=start;i<=9;i++){
            list.add(i);
            solve(i+1,k-1,target-i,list);
            list.remove(list.size()-1);
        }
    }
}