/*
Pattern: Divide and Conquer + Fast Exponentiation + Modular Arithmetic

Time: O(log n)
Space: O(log n)

Idea:
- Every pair of indices contributes 5 × 4 = 20 choices.
- Therefore:
    Even n -> answer = 20^(n/2)
    Odd n  -> answer = 5 × 20^(n/2)
- Compute 20^(n/2) using Exponentiation by Squaring.
- Apply modulo after every multiplication to avoid overflow.
*/

class Solution {
    public long helper(long n){
        long MOD = 1000000007;
        if(n==0){
            return 1;
        }
        long y=helper(n/2);
        if(n%2==0){
            return (y*y)%MOD;
        }
        else{
            long temp=(20*y)%MOD;
            return (temp*y)%MOD;
        }
    }
    public int countGoodNumbers(long n) {
        if(n%2==0){
            return (int) helper(n/2);
        }
        else{
            long ans=(5*helper(n/2))%1000000007;
            return (int) ans;
        }
    }
}