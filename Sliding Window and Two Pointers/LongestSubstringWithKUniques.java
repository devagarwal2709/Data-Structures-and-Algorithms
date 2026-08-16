/*
Pattern: Variable Sliding Window + Frequency Array

Time:
O(n)

Space:
O(1)

Idea:
Maintain a window containing at most K distinct characters.
If the number of distinct characters exceeds K, shrink from
the left. Whenever the window has exactly K distinct characters,
update the maximum length.
*/

class Solution {
    public int longestKSubstr(String s, int k) {
        int l=0;
        int r=0;
        int[] freq=new int[26];
        int distinct=0;
        int length=-1;
        while(r<s.length()){
            char ch=s.charAt(r);
            int index=ch-'a';
            if(freq[index]==0){
                distinct++;
            }
            freq[index]++;
            while(distinct>k){
                int x=s.charAt(l)-'a';
                freq[x]--;
                if(freq[x]==0){
                    distinct--;
                }
                l++;
            }
            r++;
            if(distinct==k){
                length=Math.max(length, r-l);
            }
        }
        return length;
    }
}