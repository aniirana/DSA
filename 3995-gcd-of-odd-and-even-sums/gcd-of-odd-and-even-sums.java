class Solution {
    public int gcdOfOddEvenSums(int n) {
        int sumodd=1;
        int sumeve=2;
        int[] odd=new int[n];
        int[] eve=new int[n];
        odd[0]=sumodd;
        eve[0]=sumeve;
        for(int i=1;i<n;i++){
            sumodd+=2;
            odd[i]=sumodd;
            sumeve+=2;
            eve[i]=sumeve;
        }
        int sumo=0;
        int sume=0;
        for(int i=0;i<n;i++){
            sumo+=odd[i];
            sume+=eve[i];
        }
        
        

        return gcd(sumo,sume);
        
    }

    public int gcd(int a,int b){
        if(b==0){
            return a;
        }

         return gcd(b,a%b);
    }
}