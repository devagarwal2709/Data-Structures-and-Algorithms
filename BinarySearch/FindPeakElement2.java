/*
Pattern: Binary Search on Answer Space (2D Peak Element)

Time: O(rows * log(columns))
Space: O(1)

Idea:
Binary search on columns.
For each middle column, find the maximum element in that column.
Since it is the column maximum, it is already greater than its top and bottom neighbors.
Compare it with its left and right neighbors:
- If left is greater, search the left half.
- If right is greater, search the right half.
- Otherwise, the current cell is a valid 2D peak.
*/

class Solution {
    public int[] findPeakGrid(int[][] mat) {
        int[] ans = new int[2];
        int row=mat.length;
        int column=mat[0].length;
        int start=0;
        int end=column-1;
        while(start<=end){
            int mid=start+(end-start)/2;
            int max=Integer.MIN_VALUE;
            int a=-1;
            for(int i=0; i<row ; i++){
                if(max<mat[i][mid]){
                    max=mat[i][mid];
                    a=i;
                }
            }
            if(mid!=0 && mat[a][mid-1]>max){
                end=mid-1;
            }
            else if(mid!=column-1 && max<mat[a][mid+1]){
                start=mid+1;
            }
            else{
                ans[0]=a;
                ans[1]=mid;
                return ans;
            }
        }
        
    return ans;
    }
}