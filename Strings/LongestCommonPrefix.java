/*
Pattern: Iterative Prefix Reduction

Time: O(N × M)
Space: O(1)

Idea:
Initialize the first string as the common prefix.
Compare it with each remaining string and shrink the prefix
until it matches. The final common prefix is the answer.
*/

class Solution {
    public String longestCommonPrefix(String[] strs) {
        String common;
        if(strs.length>0){
            common=strs[0];
        }
        else{
            return "";
        }
        for(int i=1; i<strs.length; i++){
            int a=-1;
            int j=0;
            while(j<Math.min(common.length(), strs[i].length())){
                if(common.charAt(j)==strs[i].charAt(j)){
                    j++;
                }
                else if(common.charAt(j)!=strs[i].charAt(j)){
                    a=j;
                    break;
                }
            }
            if(a>0){
                common=common.substring(0, a);
            }
            else if(a==0){
                return "";
            }
            if(a==-1){
                common=common.substring(0, Math.min(common.length(), strs[i].length()));
            }
        }
        return common;
    }
}