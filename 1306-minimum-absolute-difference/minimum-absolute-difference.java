class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        List<List<Integer>> ans=new ArrayList<>();
        int n=arr.length;
        Arrays.sort(arr);
        int diff=Integer.MAX_VALUE;
        for(int i=0;i<n-1;i++){
            diff=Math.min(diff,arr[i+1]-arr[i]);
        }
        

       for(int i=0;i<n-1;i++){
            List<Integer> list=new ArrayList<>();
            if(arr[i+1]-arr[i]==diff){
                list.add(arr[i]);
                list.add(arr[i+1]);
                ans.add(list);
            }

            
       }

        return ans;
    }
}