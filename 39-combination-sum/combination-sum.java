class Solution {
    private void findcombination(int index,int[] arr,int target,List<List<Integer>> ans,List<Integer> ds){
        if(index==arr.length){
            if(target==0){
                ans.add(new ArrayList<>(ds));
            }
            return;
        }

        if(arr[index]<=target){
            ds.add(arr[index]);
            findcombination(index,arr,target-arr[index],ans,ds);
            ds.remove(ds.size()-1);
        }
        findcombination(index+1,arr,target,ans,ds);
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans=new ArrayList<>();

        findcombination(0,candidates,target,ans,new ArrayList<>());
        return ans;
        
    }
}