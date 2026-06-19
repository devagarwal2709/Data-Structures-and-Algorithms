/*
Pattern: Binary Search on Pair Index Parity

Time: O(log n)
Space: O(1)

Idea:
Before the single element:
- Every pair starts at an even index.
After the single element:
- Every pair starts at an odd index.

At each step:
- If nums[mid] == nums[mid + 1], the pair starts at mid.
  Check whether mid is even or odd to determine
  which side contains the single element.
- If nums[mid] == nums[mid - 1], the pair starts at mid - 1.
  Check whether (mid - 1) is even or odd to determine
  which side contains the single element.
- If nums[mid] differs from both neighbors,
  nums[mid] is the single element.

*/

class Solution {
    public int singleNonDuplicate(int[] nums) {
        int start=0;
        int end=nums.length-1;
        while(start<end){
            int mid=start+(end-start)/2;
            if(nums[mid]==nums[mid+1]){
                if(mid%2==0){
                    start=mid+2;
                }
                else{
                    end=mid-1;
                }
            }
            else if(nums[mid]==nums[mid-1]){
                if((mid-1)%2==0){
                    start=mid+1;
                }
                else{
                    end=mid-2;
                }
            }
            else{
                start=mid;
                break;
            }
        }
        return nums[start];
    }
}