/*
Pattern: Sliding Window + HashMap

Time: O(n)

Space: O(min(n, charset))

Idea:
Store the last seen index of each character.
If the character is inside the current window, move the left boundary to lastIndex + 1.
Update the last seen index and maintain the maximum window length.
*/

class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character,Integer> map=new HashMap<>();
        int start=0;
        int length=0;
        for(int i=0; i<s.length(); i++){
            char ch=s.charAt(i);
            if(map.containsKey(ch) && map.get(ch)>=start){
                start=map.get(ch)+1;
                map.put(ch, i);
            }
            else{
                map.put(ch, i);
            }
            length=Math.max(length, i-start+1);
        }
        return length;
    }
}