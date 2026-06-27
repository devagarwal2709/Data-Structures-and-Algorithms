/*
Pattern: Frequency Counting (Fixed Alphabet)

Time: O(n)
Space: O(1)

Idea:
Count character frequencies of the first string using an array
of size 26, then decrement while traversing the second string.
If any frequency becomes negative, the strings are not anagrams.
*/

class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()){
            return false;
        }
        int[] arr = new int[26];
        for(int i=0; i<s.length(); i++){
            arr[s.charAt(i)-'a']++;
        }
        for(int i=0; i<t.length(); i++){
            arr[t.charAt(i)-'a']--;
            if(arr[t.charAt(i)-'a']==-1){
                return false;
            }
        }
        return true;
    }
}