/*
Pattern: Binary Search on Rotated Sorted Array

Time: O(log n)
Space: O(1)

Idea:
At every iteration, at least one half of the array
([start...mid] or [mid...end]) is sorted.
1. Find the sorted half.
2. Check if target lies inside that sorted range.
3. If yes, search in that half.
4. Otherwise, search in the other half.
*/

class Solution {
    public int search(int[] nums, int target) {
        int start=0;
        int end=nums.length-1;
        while(start<=end){
            int mid=start+(end-start)/2;
            if(nums[mid]==target){
                return mid;
            }
            if(nums[start]<=nums[mid]){
                if(nums[start]<=target  && target<=nums[mid]){
                    end=mid-1;
                }
                else{
                    start=mid+1;
                }
            }
            else if(nums[mid]<=nums[end]){
                if(nums[mid]<=target && target<=nums[end]){
                    start=mid+1;
                }
                else{
                    end=mid-1;
                }
            }
        }
        return -1;
    }
}