/*
Pattern: Sorting + Two Pointers + Duplicate Skipping

Time: O(n^2)
Space: O(1)

Idea:

1. Sort the array.
2. Fix one element at index i.
3. Use two pointers:
      l = i + 1
      r = n - 1
4. If sum == 0, store triplet.
5. If sum < 0, move l forward.
6. If sum > 0, move r backward.
7. Skip duplicate values for i, l and r
   to avoid generating duplicate triplets.

*/

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0; i<nums.length; i++){
            int l=i+1;
            int r=nums.length-1;
            if(i>0 && nums[i]==nums[i-1]){
                continue;
            }
            while(l<r){
                if(nums[i]+nums[l]+nums[r]==0){
                    List<Integer> triplet = new ArrayList<>();
                    triplet.add(nums[i]);
                    triplet.add(nums[l]);
                    triplet.add(nums[r]);
                    list.add(triplet);
                    l++;
                    r--;
                    while(l<r && nums[l]==nums[l-1]){
                        l++;
                    }
                    while(l<r && nums[r]==nums[r+1]){
                        r--;
                    }
                }
                else if(nums[i]+nums[l]+nums[r]>0){
                    r--;
                }
                else if(nums[i]+nums[l]+nums[r]<0){
                    l++;
                }
            }
        }
        return list;
    }
}