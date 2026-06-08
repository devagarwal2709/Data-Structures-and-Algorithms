/*
Pattern: Merge-style Traversal (Two Pointers)
Time: O(n + m)
Space: O(n + m)

Idea:
Traverse both sorted arrays together.
Add only unique elements.
*/

class Solution {
    public static ArrayList<Integer> findUnion(int a[], int b[]) {
        ArrayList<Integer> ans = new ArrayList<>();
        int i = 0;
        int j = 0;
        while (i < a.length && j < b.length) {
            if (a[i] <= b[j]) {
                if (ans.size() == 0 || ans.get(ans.size() - 1) != a[i]) {
                    ans.add(a[i]);
                }
                i++;
            }
            else {
                if (ans.size() == 0 || ans.get(ans.size() - 1) != b[j]) {
                    ans.add(b[j]);
                }
                j++;
            }
        }
        while (i < a.length) {
            if (ans.size() == 0 || ans.get(ans.size() - 1) != a[i]) {
                ans.add(a[i]);
            }
            i++;
        }
        while (j < b.length) {
            if (ans.size() == 0 || ans.get(ans.size() - 1) != b[j]) {
                ans.add(b[j]);
            }
            j++;
        }
        return ans;
    }
}

