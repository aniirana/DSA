class Solution {
    List<List<Integer>> ans=new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        solve(0,target,candidates,new ArrayList<>());

        return ans;
    }

    public void solve(int index,int target,int[] candidates,List<Integer> list){
        if(target==0){
            ans.add(new ArrayList(list));
            return;
        }
       for(int i=index;i<candidates.length;i++){

         if (i > index && candidates[i] == candidates[i - 1])
                continue;

        if (candidates[i] > target)
                break;

            list.add(candidates[i]);

            solve(i+1,target-candidates[i],candidates,list);

            //bt
            list.remove(list.size()-1);

            
       }
    }
}