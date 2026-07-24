/*
Pattern: Sieve of Eratosthenes

1. Assume every number is prime.
2. Traverse only till √n.
3. If current number is still prime, mark all its multiples as non-prime.
4. Start marking from i*i (smaller multiples are already processed).
5. Count remaining prime numbers.

Time: O(n log log n)
Space: O(n)
*/

class Solution {
    public int countPrimes(int n) {
        boolean[] arr=new boolean[n];
        Arrays.fill(arr, true);
        for(int i=2; i*i<=n; i++){
            if(arr[i]){
                for(int k=i*i; k<n; k+=i){
                    arr[k]=false;
                }
            }
        }
        int count=0;
        for(int i=2; i<n; i++){
            if(arr[i]){
                count++;
            }
        }
        return count;
    }
}