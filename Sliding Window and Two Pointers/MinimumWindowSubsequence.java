/*
    Pattern: Forward Matching / Backward Shrinking

    Time:
    O(n²)

    Space:
    O(1)

    Idea:
    Start matching s2 from every occurrence of its first character in s1.
    Once a complete subsequence is found, move backward from the end
    to shrink the window as much as possible.
    Track the minimum valid window.
*/

class Solution {
    public String minWindow(String s1, String s2) {
        char a=s2.charAt(0);
        int max_start=0;
        int min_end=0;
        int min_length=Integer.MAX_VALUE;
        for(int i=0; i<s1.length(); i++){
            char temp=s1.charAt(i);
            if(a==temp){
                int x=i+1;
                int y=1;
                while(x<s1.length() && y<s2.length()){
                    if(s1.charAt(x)==s2.charAt(y)){
                        y++;
                    }
                    x++;
                }
                if(y==s2.length()){
                    int t=x;
                    x--;
                    y--;
                    while(y>=0){
                        if(s1.charAt(x)==s2.charAt(y)){
                            y--;
                        }
                        x--;
                    }
                    if(min_length>(t-x-1)){
                        max_start=x+1;
                        min_end=t-1;
                        min_length=t-x-1;
                    }
                }
            }
        }
        if(min_length==Integer.MAX_VALUE){
            return "";
        }
        return s1.substring(max_start, min_end+1);
    }
}
