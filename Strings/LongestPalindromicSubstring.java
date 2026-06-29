/*
Pattern: Expand Around Center

Time: O(n²)
Space: O(1)

Idea:
Treat every index as the center of an odd palindrome
and every adjacent pair as the center of an even palindrome.
Expand while both characters match and keep updating the longest palindrome.
*/

class Solution {
    public String expand(String s){
        int max_length=0;
        String ans1=s.substring(0,1);
        String ans2=s.substring(0,1);
        for(int i=0; i<s.length(); i++){
            int lp=i-1;
            int rp=i+1;
            int length=1;
            while(lp>=0 && rp<s.length()){
                if(s.charAt(lp)==s.charAt(rp)){
                    length=length+2;
                    if(max_length<length){
                    max_length=length;
                    ans1=s.substring(lp,rp+1);
                    }
                    lp--;
                    rp++;
                }
                else{
                    break;
                }
            }
            lp=i;
            rp=i+1;
            length=0;
            while(lp>=0 && rp<s.length()){
                if(s.charAt(lp)==s.charAt(rp)){
                    length=length+2;
                    if(max_length<length){
                    max_length=length;
                    ans2=s.substring(lp,rp+1);
                    }
                    lp--;
                    rp++;
                }
                else{
                    break;
                }
            }
        }
        if(ans1.length()>ans2.length()){
            return ans1;
        }
        else{
            return ans2;
        }
    }
    public String longestPalindrome(String s) {
        return expand(s);
    }
}