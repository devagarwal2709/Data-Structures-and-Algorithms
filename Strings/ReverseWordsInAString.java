/*
Pattern: Reverse Traversal + Two Pointers

Time: O(n)
Space: O(n)

Idea:
Traverse the string from right to left while identifying each
word using its start and end indices. Append each word to a
StringBuilder followed by a single space, then remove the
trailing space at the end.
*/

class Solution {
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        boolean bool=false;
        int start;
        int end=s.length()-1;
        for(int i=s.length()-1; i>=0; i--){
            if(s.charAt(i)!=' '){
                if(!bool){
                    end=i+1;
                    bool=true;
                }
                if(i==0 || s.charAt(i-1)==' '){
                    start=i;
                    sb.append(s.substring(start, end));
                    sb.append(' ');
                    bool=false;
                }
            }
        }
        sb.delete(sb.length()-1, sb.length());
        return sb.toString();
    }
}