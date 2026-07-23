/*
Pattern: Bit Manipulation (Division using Bit Shifts)

Time: O(log² n)
Space: O(1)

Idea:
Convert both numbers to positive using long to avoid overflow.
Repeatedly find the largest power-of-two multiple of the divisor
(using left shifts) that fits into the current dividend.
Subtract it, add the corresponding multiple to the quotient,
and apply the sign at the end.
*/

class Solution {
    public int divide(int dividend, int divisor) {
        boolean bool=false;
        if(dividend==Integer.MIN_VALUE && divisor==-1){
            return Integer.MAX_VALUE;
        }
        if((dividend<0 && divisor>0) || (dividend>0 && divisor<0)){
            bool=true;
        }
        long a=Math.abs((long)dividend);
        long b=Math.abs((long)divisor);
        int quotient=0;
        while(a>=b){
            long temp=b;
            int multiple=1;
            while((temp<<1)<=a){
                temp=temp<<1;
                multiple=multiple<<1;
            }
            a=a-temp;
            quotient=quotient+multiple;
        }
        if(bool){
            return -quotient;
        }
        return quotient;
    }
}