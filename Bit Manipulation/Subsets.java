/*
Pattern: Bit Manipulation (Bitmask Enumeration)

Time: O(n × 2ⁿ)
Space: O(n)  // Auxiliary space excluding output

Idea:
Treat every number from 0 to (2^n - 1) as a bitmask.
The j-th bit determines whether nums[j] is included in
the current subset. Generate all bitmasks to enumerate
every possible subset.
*/

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list=new ArrayList<>();
        List<Integer> temp=new ArrayList<>();
        for(int i=0; i<Math.pow(2, nums.length); i++){
            temp.clear();
            int j=0;
            int a=i;
            while(j<nums.length){
                if((a&1)!=0){
                    temp.add(nums[j]);
                }
                a=a>>1;
                j++;
            }
            list.add(new ArrayList(temp));
        }
        return list;
    }
}