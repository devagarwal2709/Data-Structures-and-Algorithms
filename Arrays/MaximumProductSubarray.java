/*
Pattern: DP State Tracking
Time: O(n)
Space: O(1)

Idea:

Maintain:
1. Maximum product ending at current index.
2. Minimum product ending at current index.

*/

class Solution {
    public int maxProduct(int[] nums) {

        int old_min=nums[0];
        int new_min=nums[0];
        int old_max=nums[0];
        int new_max=nums[0];
        int answer=nums[0];
        for(int i=1; i<nums.length; i++){
            int a=Math.max(nums[i], old_max*nums[i]);
            new_max=Math.max(a, old_min*nums[i]);
            int b =Math.min(nums[i], old_max*nums[i]);
            new_min=Math.min(b, old_min*nums[i]);
            answer=Math.max(new_max, answer);
            old_max=new_max;
            old_min=new_min;
        }
        return answer;
    }
}