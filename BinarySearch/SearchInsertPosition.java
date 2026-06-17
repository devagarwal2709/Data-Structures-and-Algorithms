/*
Pattern: Binary Search + Boundary Search

Time: O(log n)
Space: O(1)

Idea:
1. Perform Binary Search on the sorted array.
2. If target is found, return its index.
3. If nums[mid] < target:
   target can only be inserted to the right,
   so move right and store (mid + 1)
   as a candidate insertion position.
4. If nums[mid] > target:
   search in the left half.
*/

class Solution {
    public int searchInsert(int[] nums, int target) {
        int start=0;
        int end=nums.length-1;
        int ans=0;
        while(start<=end){
            int mid=start+(end-start)/2;
            if(nums[mid]==target){
                return mid;
            }
            else if(nums[mid]<target){
                ans=mid+1;
                start=mid+1;
            }
            else{
                end=mid-1;
            }
        }
        return ans;
    }
}