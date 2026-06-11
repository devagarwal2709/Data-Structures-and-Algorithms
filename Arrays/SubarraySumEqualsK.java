/*
Pattern: Prefix Sum + HashMap (Frequency)
Time: O(n)
Space: O(n)

Idea:

1. Maintain a running prefix sum.
2. For current sum, find how many previous prefix sums equal (sum - k).
3. Add their frequency to the answer.
4. Store/update frequency of current prefix sum.

Goal:
Count all subarrays whose sum equals k.
*/

class Solution {
    public int subarraySum(int[] nums, int k) {
        int sum=0;
        int count=0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0,1);
        for(int i=0; i<nums.length; i++){
            sum=sum+nums[i];
            if(map.containsKey(sum-k)){
                count=count+map.get(sum-k);
            }
            map.put(sum, map.getOrDefault(sum, 0)+1);
        }
        return count;

    }
}