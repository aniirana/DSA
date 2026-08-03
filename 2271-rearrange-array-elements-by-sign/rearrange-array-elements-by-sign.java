class Solution {
    public int[] rearrangeArray(int[] nums) {
        int n=nums.length;
        int negc=0;
        int posc=0;
        for(int i=0;i<n;i++){
            if(nums[i]<0){
                negc++;
            }else{
                posc++;
            }
        }

        int[] pos=new int[posc];
        int i=0;
        int j=0;
        while(i<n){
            if(nums[i]>0){
                pos[j]=nums[i];
                
                j++;
            }
            i++;
        }
        int[] neg=new int[negc];
        int a=0;
        int b=0;
        while(a<n){
            if(nums[a]<0){
                neg[b++]=nums[a];
            }
            a++;
        }

        int[] ans=new int[n];
        int k=0;
        int z=0;
        boolean flag=true;

        for(int x=0;x<n;x++){
            if(flag){
                ans[x]=pos[k++];  
                flag=false; 
            }else{
                ans[x]=neg[z++];
                flag=true;
            }
             
        }

        return ans;
    }
}