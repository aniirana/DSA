class Solution {
    List<List<Integer>> ans=new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        
    
        Arrays.sort(nums);
        solve(nums,0,new ArrayList<>());

        return ans;
        
    }

    public void solve(int[] nums,int index,List<Integer> list){
       
            ans.add(new ArrayList<>(list));
        

        for(int i=index;i<nums.length;i++){
            if(i>index && nums[i]==nums[i-1]){
                continue;
            }

            list.add(nums[i]);

            solve(nums,i+1,list);

            list.remove(list.size()-1);
        }
    }
}