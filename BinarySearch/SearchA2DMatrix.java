/*
Pattern: Matrix Search (Sorted Rows & Columns)

Time: O(m + n)
Space: O(1)

Idea:
Start from the top-right corner.
If the current element is greater than the target, move left (discard current column).
If the current element is smaller than the target, move down (discard current row).
Each comparison eliminates one entire row or column.
*/

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row=matrix.length;
        int column=matrix[0].length;
        int i=0;
        int j=column-1;
        while(i<row && j>=0){
            if(matrix[i][j]>target){
                j--;
            }
            else if(matrix[i][j]<target){
                i++;
            }
            else if(matrix[i][j]==target){
                return true;
            }
        }
        return false;
    }
}