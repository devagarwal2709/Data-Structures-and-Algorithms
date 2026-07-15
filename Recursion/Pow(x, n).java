/*
Pattern: Divide and Conquer (Exponentiation by Squaring)

Time: O(log n)
Space: O(log n)

Idea:
- Recursively compute x^(n/2).
- If n is even, answer is y * y.
- If n is odd, answer is x * y * y.
- Convert negative exponent to positive using long to safely handle Integer.MIN_VALUE.
*/

class Solution {
    public double helper(double x, long n){
        if(n==1){
            return x;
        }
        if(n%2==0){
            long a=n/2;
            double y=helper(x, a);
            return y*y;
        }
        else{
            long a=n-1;
            double y=helper(x, a/2);

            return x*y*y;
        }
    }
    public double myPow(double x, int n) {
        double temp=0;
        if(n==0){
            return 1;
        }
        else if(n<0){
            long N=-1*(long)n;
            double temp1=helper(x,N);
            temp=(1/temp1);
        }
        else{
            temp=helper(x,n);
        }
        return temp;
    }
}