class Solution {
    public List<String> letterCasePermutation(String s) {
        List<String> ans=new ArrayList<>();

        solve(0,s,ans,new StringBuilder());
        return ans;
    }

    public void solve(int i,String s,List<String> ans,StringBuilder sb){
        int n=s.length();
        if(i==n){
            ans.add(sb.toString());
            return;
        }

        char[] arr=s.toCharArray();

        if(isnum(arr[i])){
            sb.append(arr[i]);
            solve(i+1,s,ans,sb);
            sb.deleteCharAt(sb.length()-1);
            return;
        }

        sb.append(Character.toLowerCase(arr[i]));
        solve(i+1,s,ans,sb);
        sb.deleteCharAt(sb.length()-1);

        sb.append(Character.toUpperCase(arr[i]));
        solve(i+1,s,ans,sb);
        sb.deleteCharAt(sb.length()-1);


        

    }

    public boolean isnum(char ch){
        if(ch=='0' || ch=='1' ||ch=='2' ||ch=='3' ||ch=='4' ||ch=='5' ||ch=='6' ||ch=='7' ||ch=='8' ||ch=='9'){
            return true;
        }

        return false;
    }
}