class Solution {
     List<String> result =new ArrayList<>();
    public List<String> letterCombinations(String digits) {
       
        int n=digits.length();
        if(digits==null || n==0){
            return result;
        }

        String[] mapping={"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        backtrack(digits,0,new StringBuilder(), mapping);
        return result;
    }

    public void backtrack(String digits,int index,StringBuilder current,String[] mapping){
        
        if(index==digits.length()){
            result.add(current.toString());
            return;
        }

        String letters=mapping[digits.charAt(index)-'0'];
        
        for(char ch:letters.toCharArray()){
            current.append(ch);
             backtrack(digits,index+1,current,mapping);

            current.deleteCharAt(current.length()-1);
        }
    }
}