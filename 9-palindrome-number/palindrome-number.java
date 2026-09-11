class Solution {
    public boolean isPalindrome(int x) {
        int rem;
        int temp=x;
        int rev=0;
        if(x<0){
            return false;
        }
        else{
            while(x>0){
                rem=x%10;
                rev=(rev*10)+rem;
                x=x/10;
            }
        if(temp==rev){
            return true;
        }   
        else
            return false;
        }
    }
}