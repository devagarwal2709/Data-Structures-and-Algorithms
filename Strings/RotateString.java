/*
Pattern: String Rotation (Concatenation Trick)

Time: O(n)
Space: O(n)

Idea:
If goal is a rotation of s, then it must appear as a substring
of (s + s). First check equal lengths, then verify using contains().
*/

class Solution {
    public boolean rotateString(String s, String goal) {
        if(s.length()!=goal.length()){
            return false;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(s);
        sb.append(s);
        if(sb.toString().contains(goal)){
            return true;
        }
        return false;
    }
}