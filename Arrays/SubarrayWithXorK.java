/*
Pattern: Prefix XOR + HashMap Frequency
Time: O(n)
Space: O(n)

Idea:
1. Maintain running prefix XOR.
2. For current prefix XOR = P,
   required previous prefix XOR = P ^ K.
3. Frequency of (P ^ K) gives the number
   of valid subarrays ending at current index.
4. Store prefix XOR frequencies in HashMap.
*/

public class Solution {
    public static int subarraysWithSumK(int []a, int b) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int count=0;
        int xor=0;
        map.put(0,1);
        for(int i=0; i<a.length; i++){
            xor=xor^a[i];
            if(map.containsKey(xor^b)){
                count=count+map.get(xor^b);
            }
            map.put(xor, map.getOrDefault(xor, 0)+1);
        }
        return count;
    }
}