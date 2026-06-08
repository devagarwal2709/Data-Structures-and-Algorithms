/*
Pattern: Prefix Sum + HashMap
Time: O(n)
Space: O(n)

Idea:
Store first occurrence of each prefix sum.
*/

class Solution {
    public int longestSubarray(int[] arr, int k) {
        HashMap<Integer,Integer> hash = new HashMap<>();
        int n=arr.length;
        int sum=0;
        int max=0;
        for(int i=0; i<n; i++){
            sum=sum+arr[i];
            if(sum==k){
                if(i+1>max){
                max=i+1;
                }
            }
            if(hash.containsKey(sum-k)){
                if(i-hash.get(sum-k)>max){
                   max=i-hash.get(sum-k); 
                }
            }
            if(!hash.containsKey(sum)){
            hash.put(sum, i);
            }
        }
        return max;
    }
}