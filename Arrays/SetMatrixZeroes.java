/*
Pattern: Matrix Marking (In-Place)
Time: O(m*n)
Space: O(1)

Idea:
1. Check whether the first row and first column
   originally contain a zero.
2. Use the first row and first column as marker arrays.
   - matrix[i][0] = 0 -> Row i should be zero.
   - matrix[0][j] = 0 -> Column j should be zero.
3. Traverse the remaining matrix and place markers
   whenever a zero is found.
4. Zero marked rows and columns using the markers.
5. Finally handle the first row and first column
   using the saved boolean flags.
*/

class Solution {
    public void setZeroes(int[][] matrix) {
        boolean firstRowZero = false;
        boolean firstColZero = false;
        for(int i=0; i<matrix.length; i++){
            if(matrix[i][0]==0){
                firstColZero = true;
            }
        }
        for(int i=0; i<matrix[0].length; i++){
            if(matrix[0][i]==0){
                firstRowZero = true;
            }
        }
        for(int i=1; i<matrix.length; i++){
            for(int j=1; j<matrix[0].length; j++){
                if(matrix[i][j]==0){
                    matrix[i][0]=0;
                    matrix[0][j]=0;
                }
            }
        }

       for(int i=1; i<matrix.length; i++){
            if(matrix[i][0]==0){
                for(int j=1; j<matrix[0].length; j++){
                    matrix[i][j]=0;
                }
            }
        }
        for(int j=1; j<matrix[0].length; j++){
            if(matrix[0][j]==0){
                for(int i=1; i<matrix.length; i++){
                    matrix[i][j]=0;
                }
            }
        }
        if(firstColZero){
            for(int i=0; i<matrix.length; i++){
                matrix[i][0]=0;
            }
        }
        if(firstRowZero){
            for(int j=0; j<matrix[0].length; j++){
                matrix[0][j]=0;
            }
        }
    }
}