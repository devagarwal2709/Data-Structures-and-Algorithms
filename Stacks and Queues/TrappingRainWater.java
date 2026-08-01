/*
Pattern: Two Pointers + Running Maxima

Time:
O(n)

Space:
O(1)

Idea:
Maintain two pointers from both ends along with
leftMax and rightMax.

Always process the side with the smaller height,
since its opposite boundary is guaranteed to be
at least as tall. Update the corresponding maximum
or add trapped water using the stored maximum.
*/

class Solution {
    public int trap(int[] height) {
        int l=0;
        int r=height.length-1;
        int count=0;
        int leftmax=-1;
        int rightmax=-1;
        while(l<=r){
            if(height[l]<=height[r]){
                if(leftmax<=height[l]){
                    leftmax=height[l];
                }
                else{
                    count=count+leftmax-height[l];
                }
                l++;
            }
            else if(height[l]>height[r]){
                if(rightmax<=height[r]){
                    rightmax=height[r];
                }
                else{
                    count=count+rightmax-height[r];
                }
                r--;
            }
        }
        return count;
    }
}