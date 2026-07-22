class Solution {
    List<String> ans=new ArrayList<>();
    int[] min={1,2,4,8,16,32};
    int[] hr={1,2,4,8};
    public List<String> readBinaryWatch(int turnedOn) {
        
        solve(0,turnedOn,0,0);
        return ans;
    }

    public void solve(int idx,int k,int hrs,int mins){
        if(k==0){
            if(mins<=59 && hrs<=11){
                ans.add(hrs+":"+(mins<10?"0"+mins:mins));
            }
            return;
            
        }
        if(idx==10){
            return;
        }

       
        //not take
        solve(idx+1,k,hrs,mins);

        //take
        if(idx<4){
            solve(idx+1,k-1,hrs+hr[idx],mins);
        }else{
            solve(idx+1,k-1,hrs,mins+min[idx-4]);
        }
      
       
    }
}