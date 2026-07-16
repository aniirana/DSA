class Solution {
    public List<String> letterCasePermutation(String s) {
        List<String> ans=new ArrayList<>();

        solve(0,ans,s,new StringBuilder());

        return ans;
    }

    public void solve(int idx,List<String> ans,String s,StringBuilder str){
        if(idx==s.length()){
            ans.add(str.toString());
            return;
        }

        char[] arr=s.toCharArray();

        if(isDigit(arr[idx])){
            str.append(arr[idx]);
            
            solve(idx+1,ans,s,str);
            str.deleteCharAt(str.length() - 1);
            return;
        } 

        
        str.append(Character.toLowerCase(arr[idx]));
        solve(idx+1,ans,s,str);
        str.deleteCharAt(str.length() - 1);

        
        str.append(Character.toUpperCase(arr[idx]));
        solve(idx+1,ans,s,str);
        str.deleteCharAt(str.length() - 1);



    }


    public boolean isDigit(char ch){
        if(ch=='0' || ch=='1' || ch=='2' || ch=='3' || ch=='4' || ch=='5' ||
            ch=='6' || ch== '7' || ch=='8' || ch=='9'){
                return true;
            }

        return false;
    }
}