class Solution {
    public boolean checkValidGrid(int[][] grid) {
        return solve(grid,0,0,0);
    }

    public boolean solve(int[][] grid,int row,int col,int index){
        int n=grid.length;
        if(row<0 || row>=n || col >=n || col<0 || grid[row][col]!=index){
            return false;
        }

        if(index==n*n-1){
            return true;
        }

        boolean ans1=solve(grid,row+2,col-1,index+1);
        boolean ans2=solve(grid,row+2,col+1,index+1);
        boolean ans3=solve(grid,row-2,col-1,index+1);
        boolean ans4=solve(grid,row-2,col+1,index+1);
        boolean ans5=solve(grid,row+1,col-2,index+1);
        boolean ans6=solve(grid,row+1,col+2,index+1);
        boolean ans7=solve(grid,row-1,col-2,index+1);
        boolean ans8=solve(grid,row-1,col+2,index+1);

        return ans1 || ans2 || ans3 || ans4 || ans5 || ans6 || ans7 || ans8;
    }
}