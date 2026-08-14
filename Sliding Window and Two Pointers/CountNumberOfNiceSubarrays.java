/*
Pattern: Exactly K → AtMost(K) - AtMost(K-1)

Time:
O(n)

Space:
O(1)

Idea:
Treat odd numbers as the elements being counted.
Use a sliding window to count subarrays containing at most K odd numbers.
Exactly K is obtained by subtracting AtMost(K-1) from AtMost(K).
*/

class Solution {
    public int atMost(int[] nums, int a){
        int l=0;
        int r=0;
        int odd_count=0;
        int count=0;
        while(r<nums.length){
            if(nums[r]%2==1){
                odd_count++;
            }
            while(l<=r && odd_count>a){
                if(nums[l]%2==1){
                    odd_count--;
                }
                l++;
            }
            if(odd_count<=a){
                count+=r-l+1;
            }
            r++;
        }
        return count;
    }
    public int numberOfSubarrays(int[] nums, int k) {
        int ans=atMost(nums, k)-atMost(nums, k-1);
        return ans;
        
    }
}