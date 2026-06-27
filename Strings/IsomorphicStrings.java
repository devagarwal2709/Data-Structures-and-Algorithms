/*
Pattern: Hashing (One-to-One Character Mapping)

Time: O(n)
Space: O(n)

Idea:
Maintain a HashMap for s -> t mapping and a HashSet to ensure
each character in t is mapped only once. Verify existing mappings
and reject duplicate target characters.
*/

class Solution {
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character, Character> map = new HashMap<>();
        HashSet<Character> set = new HashSet<>();
        if(s.length()!=t.length()){
            return false;
        }
        for(int i=0; i<s.length(); i++){
            if(!map.containsKey(s.charAt(i))){
                if(!set.contains(t.charAt(i))){
                map.put(s.charAt(i), t.charAt(i)); 
                set.add(t.charAt(i));  
                }
                else{
                    return false;
                }
            }
            else{
                if(t.charAt(i)!=map.get(s.charAt(i))){
                    return false;
                }
            }
            
            
        }
        return true;
    }
}