class Solution {
    public void solveSudoku(char[][] board) {
       solve(board);
    }



    public boolean solve(char[][] board){
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {

                if (board[i][j] == '.') {

                    for (char ch = '1'; ch <= '9'; ch++) {

                        if (check(i, j, board, ch)) {

                            board[i][j] = ch;

                            if (solve(board)) {
                                return true;
                            }

                            // Backtrack
                            board[i][j] = '.';
                        }
                    }

                    // No number can be placed here
                    return false;
                }
            }
        }

        // No empty cell left
        return true;
    }

    public boolean check(int row,int col,char[][] board,char ch){
        //check row
        for(int i=0;i<board[0].length;i++){
            if(board[row][i]==ch){
                return false;
            }
        }
        //check col
        for(int j=0;j<board.length;j++){
            if(board[j][col]==ch){
                return false;
            }
        }
        //check grid
        int start=(row/3)*3;
        int end=(col/3)*3;

        for(int i=start;i<start+3;i++){
            for(int j=end;j<end+3;j++){
                if(board[i][j]==ch){
                    return false;
                }
            }
        }

        return true;
    }
}