class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list=new ArrayList<>();
        int left=0;
        int right=matrix[0].length-1;
        int top=0;
        int bottom=matrix.length-1;
        while(top<=bottom&&left<=right){
            for(int i=left;i<=right;i++){
                list.add(matrix[top][i]);
            }
            top++;

            for(int i=top;i<=bottom;i++){
                list.add(matrix[i][right]);
            }
            right--;
                if(top<=bottom){
            for(int i=right;i>=left;i--){
                list.add(matrix[bottom][i]);
            }
            bottom--;}
            if(left<=right){
            for(int i=bottom;i>=top;i--){
                list.add(matrix[i][left]);
            }
            left++;
            }
           

    
        }
        return list;

        
    }
}

// Why these two checks are needed
// if (top <= bottom)

// 👉 Prevents re-traversing the same row when only one row is left.

// After moving top → bottom and shrinking boundaries, sometimes top crosses bottom.
// Without this check, you would traverse the same row again → duplicate elements.
// if (left <= right)

// 👉 Prevents re-traversing the same column when only one column is left.

// After shrinking left and right, they may cross.
// Without this check, you would traverse the same column again → duplicate elements.
// When this actually matters

// Example:

// 1 2 3
// 4 5 6

// After first round:

// Only one row remains
// Without top <= bottom, you'll traverse it twice
// Summary of logic
// First two loops (top row, right column) are always safe
// Last two loops (bottom row, left column) can overlap → need checks
// Time Complexity

// 👉 O(m × n)
// Every element is visited exactly once

// Space Complexity

// 👉 O(1) (extra space)
// 👉 O(m × n) if counting output list

// Key point

// Those conditions avoid duplicate traversal when matrix reduces to a single row or column.

// dry run with 3 by 3
// Dry Run for 3×3 Matrix

// Matrix:

// 1  2  3
// 4  5  6
// 7  8  9

// Initial:

// top = 0, bottom = 2
// left = 0, right = 2
// Iteration 1

// 1. Left → Right (top row)

// Add: 1 2 3
// top = 1

// 2. Top → Bottom (right column)

// Add: 6 9
// right = 1

// 3. Right → Left (bottom row) (since top ≤ bottom → 1 ≤ 2 ✔)

// Add: 8 7
// bottom = 1

// 4. Bottom → Top (left column) (since left ≤ right → 0 ≤ 1 ✔)

// Add: 4
// left = 1

// Result so far:

// [1, 2, 3, 6, 9, 8, 7, 4]
// Iteration 2

// Now:

// top = 1, bottom = 1
// left = 1, right = 1

// 1. Left → Right

// Add: 5
// top = 2

// 2. Top → Bottom

// Skipped (top > bottom)

// 3. Right → Left

// Skipped

// 4. Bottom → Top

// Skipped
// Final Output
// [1, 2, 3, 6, 9, 8, 7, 4, 5]
// Where checks matter here

// In 2nd iteration:

// top <= bottom → false after adding 5
// left <= right → false

// 👉 Prevents revisiting the same center cell again.

// 2. Top → Bottom

// Skipped (top > bottom)
// we didnt wite condion fo this case

// Correct — you did not explicitly write a condition for the second step:

// for(int i = top; i <= bottom; i++)
// Why it still works

// Because the while condition already guarantees safety:

// while (top <= bottom && left <= right)

// So when this loop runs:

// top <= bottom is already true
// Hence no need for an extra check before this loop
// What happens in 2nd iteration (3×3 case)

// After adding 5:

// top = 2
// bottom = 1

// Now:

// for(int i = top; i <= bottom; i++)   // i = 2 → 2 <= 1 ❌

// 👉 Loop automatically skips because condition fails

// Why extra checks are needed only for last two loops
// First two traversals:
// Controlled safely by while + loop condition
// Last two traversals:
// Boundaries already changed inside loop
// Can cause duplicate traversal

// So you explicitly guard:

// if (top <= bottom)
// if (left <= right)
// Key idea
// For loops auto-handle invalid ranges → skip execution
// But after shrinking boundaries, extra checks are needed to avoid duplicates
// Final conclusion

// 👉 No condition needed for "Top → Bottom" because:

// Either while ensures validity
// Or loop condition prevents execution automatically