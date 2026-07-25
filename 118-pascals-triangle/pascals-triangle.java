class Solution {
     List<List<Integer>> ans=new ArrayList<>();
    public List<List<Integer>> generate(int numRows) {
    

        for(int i=0;i<numRows;i++){
            List<Integer> list=new ArrayList<>();
            for(int j=0;j<=i;j++){
                if(j==0 || j==i){
                    list.add(1);
                }else{
                    int prev=ans.get(i - 1).get(j - 1) + ans.get(i - 1).get(j);
                    list.add(prev);
                }
                
          
            }
            ans.add(new ArrayList<>(list));
        }
       
       return ans;

    }


    
}