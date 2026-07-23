/*
Pattern: Bit Manipulation (XOR Partition)

Time: O(n)
Space: O(1)

Idea:
XOR all numbers to obtain a ^ b, where a and b are the two unique numbers.
Choose any set bit from this XOR to partition the array into two groups.
Since duplicates fall into the same group and cancel out, XORing each group
individually gives the two unique numbers.
*/

class Solution {
    public int[] singleNumber(int[] nums) {
        int xor=0;
        for(int i=0; i<nums.length; i++){
            xor=xor^nums[i];
        }
        int position=0;
        while(xor!=0){
            if((xor&1)!=0){
                break;
            }
            xor=xor>>1;
            position++;
        }
        int xor1=0;
        int xor2=0;
        for(int i=0; i<nums.length; i++){
            int temp=nums[i];
            for(int j=0; j<position; j++){
                temp=temp>>1;
            }
            if((temp&1)==0){
                xor1=xor1^nums[i];
            }
            else{
                xor2=xor2^nums[i];
            }
        }
        int[] ans=new int[]{xor1, xor2};
        return ans;
    }
}