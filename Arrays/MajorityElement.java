/*
Pattern: Moore Voting Algorithm
Time: O(n)
Space: O(1)

Idea:
Majority element survives all cancellations.
*/

class Solution {
    public int majorityElement(int[] nums) {
        int a=nums[0];
        int vote=0;
        for(int i=0; i<nums.length; i++){
            if(nums[i]==a){
                vote++;
            }
            else{
                vote--;
            }
            if(vote==0){
                a=nums[i];
                vote=1;
            }
        }
        return a;
    }
}