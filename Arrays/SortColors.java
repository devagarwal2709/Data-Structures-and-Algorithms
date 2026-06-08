/*
Pattern: Dutch National Flag (3 Pointers)
Time: O(n)
Space: O(1)

Idea:
0 -> Left
1 -> Middle
2 -> Right
*/

class Solution {
    public void sortColors(int[] nums) {
        int low=0;
        int mid=0;
        int high=nums.length-1;
        while(mid<=high){
            if(nums[mid]==2){
                int temp=nums[mid];
                nums[mid]=nums[high];
                nums[high]=temp;
                high--;
            }
            else if(nums[mid]==0){
                int temp=nums[mid];
                nums[mid]=nums[low];
                nums[low]=temp;
                low++;
                mid++;
            }
            else{
                mid++;
            }
        }
    }
}