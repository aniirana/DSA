class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<List<Integer>> ans=new ArrayList<>();

        for(int i=0;i<=rowIndex;i++){
            List<Integer> list=new ArrayList<>();
            for(int j=0;j<=i;j++){
                if(j==0 || j==i){
                    list.add(1);
                }else{
                    int val=ans.get(i-1).get(j-1)+ans.get(i-1).get(j);
                    list.add(val);
                }
            }

            ans.add(new ArrayList<>(list));
        }

         List<Integer> res=new ArrayList<>();
        for(int i=0;i<=rowIndex;i++){
            int val=ans.get(rowIndex).get(i);
            res.add(val);
        }

        return res;
    }

   
}