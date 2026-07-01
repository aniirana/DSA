class Solution {
    public List<String> generateParenthesis(int n) {
        int open=n;
        int close=n;

        List<String> ans=new LinkedList<>();
        String current=""; 
        answer(open,close,ans,current);
        return ans;
    }
    public void answer(int open,int close,List<String> ans,String current){
        
        if(open==0 && close==0){
            ans.add(current);
            return;
        }

        if(open>0){
            answer(open-1,close,ans,current+"(");
        }
        
        if(close>open){
            answer(open,close-1,ans,current+")");
        }
        
    }
}