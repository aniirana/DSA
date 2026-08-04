class Solution {
    public String decodeString(String s) {
        int n=s.length();
        Stack<Integer> s1=new Stack<>();
        Stack<String> s2=new Stack<>();

        char[] arr=s.toCharArray();
        int num=0;
        String curr="";
        for(int i=0;i<n;i++){

            if(isnum(arr[i])){
                num=num*10+(arr[i]-'0');
            }
            else if(arr[i]=='['){
                s1.push(num);
                s2.push(curr);

                num=0;
                curr="";
            }

            else if(arr[i]==']'){
                String prev=s2.pop();
                int rpt=s1.pop();

                String solved="";

                for(int j=0;j<rpt;j++){
                   solved+= curr;
                }

                curr=prev+solved;
            }
            else{
                curr+=arr[i];
            }
        }
        return curr;
        
    }

    public boolean isnum(char ch){
        if(ch=='0' || ch=='1' || ch=='2' || ch=='3' || ch=='4' || ch=='5' || ch=='6' || ch=='7' || ch=='8' || ch=='9'){
            return true;
        }
        return false;
    }
}