class Solution {
    List<String> ans=new ArrayList<>();
    public List<String> restoreIpAddresses(String s) {
        
        solve(s,0,0,new StringBuilder());
        return ans;
    }

    public void solve(String s,int i,int k,StringBuilder sb){
        int n=s.length();

        if(k==4 || i==n){
            if(i==n && k==4){
                ans.add(sb.toString());
            }
            return;
        }

        for(int len=1;len<4 && i + len <= s.length();len++){
            String part=s.substring(i,i+len);

            if(!isvalid(part)){
                continue;
            }
             int oldLength = sb.length();

            sb.append(part);

       
            if (k < 3) {
                sb.append(".");
            }

            solve(s, i + len, k + 1, sb);

            sb.setLength(oldLength);
        }
    }

   public boolean isvalid(String s){
        int n=s.length();

        if(n>3){
            return false;
        }

        if(s.charAt(0)=='0' && n>1){
            return false;
        }

        int num = Integer.parseInt(s);

        if(num > 255)
            return false;

        return true;
   }


}