/*
Pattern: Two-Sided Selection / Prefix-Suffix

Time:
O(k)

Space:
O(1)

Idea:
Try every possible distribution of k cards between the two ends.
Start with taking all k cards from the left, then move one selected
card at a time from the left selection to the right selection.
Track the maximum score among all k + 1 combinations.
*/

class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int left_sum=0;
        int right_sum=0;
        int temp=0;
        for(int i=0; i<k; i++){
            left_sum+=cardPoints[temp];
            temp++;
        }
        temp--;
        int r=cardPoints.length-1;
        int max_score=0;
        for(int i=0; i<k; i++){
            int score=left_sum+right_sum;
            max_score=Math.max(max_score, score);
            left_sum-=cardPoints[temp];
            right_sum+=cardPoints[r];
            r--;
            temp--;
        }
        max_score=Math.max(max_score, left_sum+right_sum);
        return max_score;
    }
}