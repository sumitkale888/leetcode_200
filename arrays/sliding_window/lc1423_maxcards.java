class Solution {
    public int maxScore(int[] cardPoints, int k) {
          int lsum=0;
          int n=cardPoints.length;
        for(int i=0;i<k;i++){
            lsum+=cardPoints[i];
        }
        int max=lsum;
        int rsum=0;
        for(int i=1;i<=k;i++){
            lsum=lsum-cardPoints[k-i];
            rsum=rsum+cardPoints[n-i];
            max=Math.max(max,lsum+rsum);
        }
        return max;

      
    }
}
// 👉 You must pick exactly k cards from the ends (left or right)

// Core Thinking

// Instead of thinking “which k to take”, think:

// 👉 How many to take from left vs right

// Take k from left → initial case
// Then gradually:
// remove from left
// add from right
// What your code is doing
// Step 1: Start with all from left
// take first k elements

// 👉 This is one valid answer

// Step 2: Shift selection

// Loop does:

// remove 1 from left + add 1 from right
// remove 2 from left + add 2 from right
// ...

// 👉 You are trying all combinations:

// (k,0), (k-1,1), (k-2,2), ..., (0,k)
// Why this works
// You can only pick from ends
// So every valid selection =
// 👉 some prefix + some suffix
// No other combination is possible
// Visualization
// [1,2,3,4,5,6,1], k = 3

// Try all:

// [1,2,3] → left 3
// [1,2] + [1]
// [1] + [6,1]
// [5,6,1] → right 3

// 👉 Take max of all

// Key Insight

// 👉 Instead of checking all subsets,
// you only check k + 1 possibilities