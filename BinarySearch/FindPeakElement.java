/*
Pattern: Binary Search on Slope

Time: O(log n)
Space: O(1)

Idea:
A peak element is greater than its neighbors.

At each step:
- If nums[mid-1] < nums[mid] < nums[mid+1],
  we are on an increasing slope.
  A peak must exist on the right.
- If nums[mid-1] > nums[mid],
  we are on a decreasing slope.
  A peak must exist on the left.
- If nums[mid] is greater than both neighbors,
  it is a peak.
When only one or two elements remain,
return the index of the larger element.
*/

class Solution {
    public int findPeakElement(int[] nums) {
        int start=0;
        int end=nums.length-1;
        int a=0;
        while(start<end && (end-start)>1){
            int mid=start+(end-start)/2;
            if(nums[mid-1]<nums[mid]){
                if(nums[mid]>nums[mid+1]){
                    a=mid;
                    break;
                }
                else{
                    start=mid+1;
                }
            }
            else{
                end=mid-1;
            }
        }
        if((end-start)<=1){
            if(nums[start]>nums[end]){
                return start;
            }
            else{
                return end;
            }
        }
        if(start==end){
            return start;
        }
        return a;
    }
}