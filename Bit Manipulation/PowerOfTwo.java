/*
Pattern:Bit Manipulation (Power of Two)

Time:O(1)
Space:O(1)

Idea:
A power of 2 has exactly one set bit.
(n - 1) clears that bit and sets all lower bits.
So, n & (n - 1) becomes 0 only for powers of 2.
*/

class Solution {
    public boolean isPowerOfTwo(int n) {
        if(n<=0){
            return false;
        }
        return ((n-1)&n)==0;
    }
}