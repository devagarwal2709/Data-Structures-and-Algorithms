/*
Pattern: Sorting + Interval Merging
Time: O(n log n)
Space: O(n)

Idea:
1. Sort intervals by start time.
2. Keep the last merged interval.
3. If current interval overlaps:
      extend the end.
4. Otherwise:
      start a new interval.

*/

class Solution {
    public int[][] merge(int[][] intervals) {
        int[][] arr = new int[intervals.length][2];
        int a=0;
        Arrays.sort(intervals, (x,y) -> {
            if(x[0]!=y[0]){
                return Integer.compare(x[0], y[0]);
            }
            return Integer.compare(x[1], y[1]);
        });
        arr[0][0]=intervals[0][0];
        arr[0][1]=intervals[0][1];
        for(int i=1; i<intervals.length; i++){
            if(arr[a][1]>=intervals[i][0]){
                if(arr[a][1]<intervals[i][1]){
                    arr[a][1]=intervals[i][1];
                }
            }
            else{
                a++;
                arr[a][0]=intervals[i][0];
                arr[a][1]=intervals[i][1];
            }
        }
        int[][] result = new int[a+1][2];
        for(int i=0; i<(a+1); i++){
            result[i][0]=arr[i][0];
            result[i][1]=arr[i][1];
        }
        return result;
    }
}