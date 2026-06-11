/*
Pattern: Boundary Traversal
Time: O(m*n)
Space: O(1)

Idea:
1. Maintain four boundaries:
   - top
   - bottom
   - left
   - right

2. Traverse the outer layer:
   - Top row    (left → right)
   - Right col  (top → bottom)
   - Bottom row (right → left)
   - Left col   (bottom → top)

3. Shrink boundaries:
   - top++
   - bottom--
   - left++
   - right--

4. Continue until boundaries cross.

Note -> Handle single remaining row/column using
boundary checks before traversing the
bottom row and left column.

*/

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        int top = 0;
        int bottom = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;
        while (top <= bottom && left <= right) {
            for (int j = left; j <= right; j++) {
                list.add(matrix[top][j]);
            }
            top++;
            for (int i = top; i <= bottom; i++) {
                list.add(matrix[i][right]);
            }
            right--;
            if (top <= bottom) {
                for (int j = right; j >= left; j--) {
                    list.add(matrix[bottom][j]);
                }
                bottom--;
            }
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    list.add(matrix[i][left]);
                }
                left++;
            }
        }
        return list;
    }
}