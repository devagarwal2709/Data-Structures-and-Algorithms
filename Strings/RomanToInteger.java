/*
Pattern: Reverse Traversal + Running Reference

Time: O(n)
Space: O(1)

Idea:
Traverse from right to left. If the current Roman value is
smaller than the previous value, subtract it; otherwise add it.
*/

class Solution {
    public int romanToInt(String s) {
        int ans=0;
        int prev=0;
        int x=0;
        for(int i=s.length()-1; i>=0; i--){
            switch(s.charAt(i)){
                case 'I':
                    x=1;
                    break;
                case 'V':
                    x=5;
                    break;
                case 'X':
                    x=10;
                    break;
                case 'L':
                    x=50;
                    break;
                case 'C':
                    x=100;
                    break;
                case 'D':
                    x=500;
                    break;
                case 'M':
                    x=1000;
                    break;
            }
            if(prev<=x){
                ans+=x;
                prev=x;;
            }
            else{
                ans-=x;
                prev=x;
            }
        }
        return ans;
    }
}