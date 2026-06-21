/*
Pattern: Binary Search on Answer

Time: O(n * log(maxDay - minDay))
Space: O(1)

Idea:
Binary search the minimum day.

For a candidate day:
- A flower is available if bloomDay[i] <= day.
- Count consecutive available flowers.
- Whenever count reaches k, form one bouquet
  and reset the count.

If bouquets >= m:
- This day works.
- Try to find a smaller valid day.

If bouquets < m:
- Need more flowers to bloom.
- Search larger days.
*/

class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        if(bloomDay.length<(long)m*k){
            return -1;
        }
        int max=bloomDay[0];
        int min=bloomDay[0];
        for(int i=0; i<bloomDay.length; i++){
            if(bloomDay[i]>max){
                max=bloomDay[i];
            }
            if(bloomDay[i]<min){
                min=bloomDay[i];
            }

        }
        int start=min;
        int end=max;
        int ans=bloomDay[0];
        while(start<=end){
            int mid=start+(end-start)/2;
            int count=0;
            int a=0;
            for(int i=0; i<bloomDay.length; i++){
                if(bloomDay[i]<=mid){
                    count++;
                    if(k==count){
                        a++;
                        count=0;
                    }
                }
                else{
                    count=0;
                }
            }
            if(a>=m){
                ans=mid;
                end=mid-1;
            }
            else if(a<m){
                start=mid+1;
            }
        }
        return ans;
    }
}