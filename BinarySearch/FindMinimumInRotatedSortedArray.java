/*
Pattern: Binary Search on Rotated Sorted Array

Time: O(log n)
Space: O(1)

Idea:
The minimum element is either:
1. The first element of a sorted half.
2. Inside the unsorted half containing the rotation point.
At each step:
- If the left half is sorted, its minimum is nums[start].
  Update answer and search the other half.
- If the right half is unsorted, the rotation point
  (and potentially the minimum) lies there.
*/

class Solution {
    public int findMin(int[] nums) {
        int start=0;
        int end=nums.length-1;
        int min=nums[0];
        while(start<=end){
            int mid=start+(end-start)/2;
            if(nums[mid]<min){
                min=nums[mid];
            }
            if(nums[start]<=nums[mid]){
                if(nums[mid]<=nums[end]){
                    if(nums[start]<min){
                        min=nums[start];
                    }
                }
                start=mid+1;
                }
            else if(nums[mid]<=nums[end]){
                end=mid-1;
                }
            }
        return min;
    }
}