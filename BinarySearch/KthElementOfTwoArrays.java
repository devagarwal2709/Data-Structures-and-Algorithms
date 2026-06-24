/*
Pattern: Binary Search on Partition

Time: O(log(min(m,n)))
Space: O(1)

Idea:
Partition both sorted arrays such that
the left half contains exactly k elements.

i = elements taken from first array
j = k - i

Valid partition:
l1 <= r2 && l2 <= r1

Answer:
max(l1, l2)
*/

class Solution {
    public int kthElement(int a[], int b[], int k) {
        int m=a.length;
        int n=b.length;
        if(m>n){
            return kthElement(b, a, k);
        }
        int start=Math.max(0, k-n);
        int end=Math.min(m, k);
        while(start<=end){
            int i=start+(end-start)/2;
            int j=k-i;
            int l1;
            int l2;
            int r1;
            int r2;
            if(i==0){
                l1=Integer.MIN_VALUE;
            }
            else{
                l1=a[i-1];
            }
            if(j==0){
                l2=Integer.MIN_VALUE;
            }
            else{
                l2=b[j-1];
            }
            if(i==m){
                r1=Integer.MAX_VALUE;
            }
            else{
                r1=a[i];
            }
            if(j==n){
                r2=Integer.MAX_VALUE;
            }
            else{
                r2=b[j];
            }
            if(Math.max(l1,l2)<=Math.min(r1,r2)){
                return Math.max(l1,l2);
            }
            else if(Math.max(l1,l2)>Math.min(r1,r2)){
                if(l1>r2){
                    end=i-1;
                }
                else if(l2>r1){
                    start=i+1;
                }
            }
        }
        return 0;
    }
}