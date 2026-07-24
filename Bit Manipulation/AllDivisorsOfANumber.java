/*
Pattern: Mathematics (Factor Pair)

Time: O(√n)
Space: O(number of divisors)

Idea:
Iterate only up to √n.
Whenever i divides n, both i and (n / i) are divisors.
Store the smaller divisors separately from the larger ones,
avoid duplicates for perfect squares, then reverse the larger
divisors and append them to obtain sorted order.
*/

import java.util.Collections;
class Solution {
    public ArrayList<Integer> getDivisors(int n) {
        ArrayList<Integer> list1=new ArrayList<>();
        ArrayList<Integer> list2=new ArrayList<>();
        for(int i=1; i*i<=n; i++){
            if(n%i==0){
                list1.add(i);
                if(i*i!=n){
                    list2.add(n/i); 
                }
                
            }
        }
        Collections.reverse(list2);
        list1.addAll(list2);
        return list1;
    }
}