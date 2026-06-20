class Solution {
    public int nthUglyNumber(int n) {
        int[] ugly=new int[n];
        int u2=0,u3=0,u5=0;
        ugly[0]=1;

        for(int i=1;i<n;i++){
            int next1=ugly[u2]*2;
            int next2=ugly[u3]*3;
            int next3=ugly[u5]*5;

            int next=Math.min(next1,Math.min(next2,next3));
            ugly[i]=next;

            if(next==next1) u2++;
            if(next==next2) u3++;
            if(next==next3) u5++;
        }
        return ugly[n-1];
        
    }
}