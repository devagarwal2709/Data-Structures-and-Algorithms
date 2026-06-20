/*
Pattern: Binary Search on Answer

Time: O(n * log(maxPile))
Space: O(1)

Idea:
Binary search the eating speed k.
For a candidate speed:
- Compute total hours needed to eat all piles.
- Hours for one pile = ceil(pile / k).
- Total hours = sum of hours for all piles.

If totalHours <= h:
- This speed works.
- Try to find a smaller valid speed.

If totalHours > h:
- Speed is too slow.
- Increase the eating speed.

The answer is the minimum speed that allows
Koko to finish all bananas within h hours.
*/

class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max=0;
        for(int i=0; i<piles.length; i++){
            if(piles[i]>max){
                max=piles[i];
            }
        }
        int start=1;
        int end=max;
        int ans=piles[0];
        while(start<=end){
        long required_hrs=0;
        int mid=start+(end-start)/2;
        for(int i=0; i<piles.length; i++){
            long a;
            if(piles[i]%mid==0){
                a=piles[i]/mid;
            }
            else{
                a=(piles[i]/mid)+1;
            }
            required_hrs+=a;
        }
        if(required_hrs<=h){
            ans=mid;
            end=mid-1;
        }
        else if(required_hrs>h){
            start=mid+1;
        }
        }
        return ans;
    }
}