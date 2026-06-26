/*
Pattern: Reverse Traversal

Time: O(n)
Space: O(n)

Idea:
Traverse the string from right to left to find the rightmost
odd digit. The required answer is the prefix ending at that
digit. If no odd digit exists, return an empty string.
*/

class Solution {
    public String largestOddNumber(String num) {
        for(int i=num.length()-1; i>=0; i--){
            if(num.charAt(i)%2!=0){
                return num.substring(0, i+1);
            }
        }
        return "";
    }
}