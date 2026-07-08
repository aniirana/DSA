class Solution {
    List<List<Integer>> ans=new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        
        
       solve(0,target,candidates,new ArrayList<>());

        return ans;
    }

    public void solve(int index,int target,int[] candidates,List<Integer> list){
            if(target==0){
                ans.add(new ArrayList<>(list));
                return;
            }
            if(index==candidates.length || target<0){
                return;
            }

            //add
            list.add(candidates[index]);

            //recurse
            solve(index,target-candidates[index],candidates,list);

            //backtrack
            list.remove(list.size()-1);
            //skip
            solve(index+1,target,candidates,list);

    }
}