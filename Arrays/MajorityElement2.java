/*
Pattern: Moore Voting Algorithm (Extended)

Time: O(n)
Space: O(1)

Idea:

1. At most 2 elements can appear more than n/3 times.
2. Maintain two candidates and two counters.
3. Match existing candidates first.
4. If a counter becomes 0, assign a new candidate.
5. If current number matches neither candidate,
   decrement both counters.
6. Voting phase gives only potential candidates.
7. Verify actual frequencies in a second pass.

*/

class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> list = new ArrayList<>();
        if(nums.length==0){
            return list;
        }
        int can1=nums[0];
        int can2=nums[0];
        int count1=0;
        int count2=0;
        for(int i=0; i<nums.length; i++){
            if(nums[i]==can1){
                count1++;
            }
            else if(nums[i]==can2){
                count2++;
            }
            else if(count1==0){
                can1=nums[i];
                count1=1;
            }
            else if(count2==0){
                can2=nums[i];
                count2=1;
            }
            else{
                count1--;
                count2--;
            }
        }
        int vote1=0;
        int vote2=0;
        for(int i=0; i<nums.length; i++){
            if(nums[i]==can1){
                vote1++;
            }
            else if(nums[i]==can2){
                vote2++;
            }
        }
        if(vote1>(nums.length/3)){
            list.add(can1);
        }
        if(vote2>(nums.length/3)){
            list.add(can2);
        }
        return list;
    }
}