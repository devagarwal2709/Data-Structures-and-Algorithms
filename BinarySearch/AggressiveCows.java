/*
Pattern: Binary Search on Answers (Aggressive Cows)

Time: O(n log n + n log(maxDistance))
Space: O(1)

Idea:
Sort stall positions.
Binary search on the minimum distance between cows.

For a candidate distance (mid),
greedily place cows from left to right.

If at least k cows can be placed,
try a larger distance.

Otherwise,
try a smaller distance.

Store the largest valid distance found.
*/

class Solution {
    public int aggressiveCows(int[] stalls, int k) {
        Arrays.sort(stalls);
        int start=1;
        int end=stalls[stalls.length-1]-stalls[0];
        int ans=-1;
        while(start<=end){
            int mid=start+(end-start)/2;
            int a=stalls[0];
            int count=1;
            for(int i=0; i<stalls.length-1; i++){
                if((stalls[i+1]-a)>=mid){
                    a=stalls[i+1];
                    count++;
                }
            }
            if(count>=k){
                ans=mid;
                start=mid+1;
            }
            else if(count<k){
                end=mid-1;
            }
        }
        return ans;
    }
}