class Solution {
    public int smallestNumber(int n, int t) {
        if(prod(n)%t==0){
            return n;
        }

        return smallestNumber(n+1,t);
    }

    public int prod(int n){
        int mul=1;
        while(n>0){
            int dig=n%10;
            mul=mul*dig;
            n=n/10;
        }
        return mul;
    }
}