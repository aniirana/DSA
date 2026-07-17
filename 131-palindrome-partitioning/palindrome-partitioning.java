class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ans=new ArrayList<>();

        solve(s,0,0,ans,new ArrayList<>());
        return ans;
    }

    public void solve(String s,int i,int e,List<List<String>> ans,List<String> list){
        if(i==s.length()){
            ans.add(new ArrayList<>(list));
            return ;
        }

        if(e==s.length()){
            return ;
        }
        String cur = s.substring(i, e + 1);
        if(ispalindrome(cur)){
            list.add(cur);
            solve(s,e+1,e+1,ans,list);
            list.remove(list.size()-1);
        }

        solve(s,i,e+1,ans,list);

        
        
    }

    public boolean ispalindrome(String s){
        int i=0;
        int j=s.length()-1;

        while(i<j){
            if(s.charAt(i++)!=s.charAt(j--)){
                return false;
            }
            
        }
        return true;
    }
}