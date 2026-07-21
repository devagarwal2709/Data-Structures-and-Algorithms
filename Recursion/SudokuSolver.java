/*
Approach:
- Backtracking
- Traverse board cell by cell.
- Skip already-filled cells.
- For empty cells, try digits 1-9.
- Place a valid digit, recurse, and backtrack if needed.

Time Complexity:
O(9^(empty cells))

Space Complexity:
O(empty cells)
*/

class Solution {
    public boolean helper2(char[][] board, int row, int column, int value){
        for(int i=0; i<9; i++){
            if(board[row][i]==(char)(value+'0') || board[i][column]==(char)(value+'0')){
                return false;
            }
        }
        int a=0;
        int b=0;
        switch(row/3){
            case 0:
            a=0;
            break;
            case 1:
            a=3;
            break;
            case 2:
            a=6;
            break;
        }
        switch(column/3){
            case 0:
            b=0;
            break;
            case 1:
            b=3;
            break;
            case 2:
            b=6;
            break;
        }
        for(int i=a; i<a+3; i++){
            for(int j=b; j<b+3; j++){
                if(board[i][j]==(char)(value+'0')){
                    return false;
                }
            }
        }
        return true;
    }
    public boolean helper(char[][] board, int row, int column){
        if(row==9){
            return true;
        }
        if(column==9){
            return helper(board, row+1, 0);
        }
        if(board[row][column]!='.'){
            return helper(board, row, column+1);
        }
        for(int i=1; i<=9; i++){
            if(helper2(board, row, column, i)){
                board[row][column]=(char)(i+'0');
                if(helper(board, row, column+1)){
                    return true;
                }
                board[row][column]='.';
            }
        }
        return false;
    }
    public void solveSudoku(char[][] board) {
        helper(board, 0, 0);
    }
}