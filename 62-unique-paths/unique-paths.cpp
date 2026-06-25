class Solution {
private:
    int solve(int row , int col, vector<vector<int>>&dp){
        // the base case
        if(row == 0 && col ==0) return 1;
        if(row<0 || col < 0) return 0;
        if(dp[row][col] != -1) return dp[row][col];

        // left 
        int left = solve(row,col-1,dp);
        int right = solve(row-1,col,dp);

        return dp[row][col] = left + right;
    }
public:
    int uniquePaths(int m, int n) {
        vector<vector<int>>dp(m,vector<int>(n,-1));
        return solve(m-1,n-1,dp);
    }
};