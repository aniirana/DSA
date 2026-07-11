class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n=startTime.length;
        int[][] jobs=new int[n][3];

        for(int i=0;i<n;i++){
            jobs[i][0]=startTime[i];
            jobs[i][1]=endTime[i];
            jobs[i][2]=profit[i];
        }

        Arrays.sort(jobs,(a,b) ->Integer.compare(a[0],b[0]));

        return solve(jobs);
    }

    public int solve(int[][] jobs){
        int n=jobs.length;
        
        int[] dp=new int[n+1];
       
       for(int k=n-1;k>=0;k--){
            int next=getnext(jobs,k+1,jobs[k][1]);
            //take 
            
                int take=jobs[k][2]+dp[next] ;//prev wala bs se
             //not take
            
                int skip=dp[k+1];
            
            dp[k]=Math.max(take,skip);
        
       }
        
        return dp[0];
    } 

    public int getnext(int[][] jobs,int start,int currend){
        int n=jobs.length;
        int end=n-1;
        int result=n;
        while(start<=end){
            int mid=start+(end-start)/2;

            if(jobs[mid][0]>=currend){
                result=mid;
                end=mid-1;
            }else{
                start=mid+1;
            }
        }
        return result;
    }
}