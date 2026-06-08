/*
Pattern: XOR
Time: O(n)
Space: O(1)

Idea:
a ^ a = 0
a ^ 0 = a

Pairs cancel out.
Only unpaired element remains.
*/

class Solution {
    public int singleNumber(int[] nums) {
        int xor=0;
        for(int i=0; i<nums.length; i++){
            xor = xor^nums[i];
        }
        return xor;
    }
}