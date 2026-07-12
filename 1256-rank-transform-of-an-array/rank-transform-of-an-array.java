class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int[] nums=new int[arr.length];
        int n=arr.length;
        for(int i=0;i<n;i++){
            nums[i]=arr[i];
        }

        Arrays.sort(nums);

        //counting smaller elements in left side
       HashMap<Integer,Integer> map=new HashMap<>();
        int rank=1;
       for(int i:nums){
            if(!map.containsKey(i)){
                map.put(i,rank++);
            }
       }
       int[] ans=new int[n];
       for(int i=0;i<n;i++){
        ans[i]=map.get(arr[i]);
       }
        return ans;
    }
}