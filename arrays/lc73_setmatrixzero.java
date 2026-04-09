class Solution {
    public void setZeroes(int[][] matrix) {
        int n=matrix.length;
        int m=matrix[0].length;
       boolean r=false;
       boolean c=false;
       for(int i=0;i<n;i++){
        if(matrix[i][0]==0){
            r=true;
        }
       }
     for(int i=0;i<m;i++){
        if(matrix[0][i]==0){
            c=true;
        }
       }

       for(int i=1;i<n;i++){
        for(int j=1;j<m;j++){
            if(matrix[i][j]==0){
                matrix[i][0]=0;
                matrix[0][j]=0;
            }
        }
       }
       for(int i=1;i<n;i++){
        for(int j=1;j<m;j++){
            if(matrix[i][0]==0||matrix[0][j]==0){
                matrix[i][j]=0;
               
            }
        }
       }
       if(r){
        for(int i=0;i<n;i++){
            matrix[i][0]=0;
        }
       }
         if(c){
        for(int i=0;i<m;i++){
            matrix[0][i]=0;
        }
       }

        
    }
}

// 🔹 Problem

// If any cell = 0
// 👉 make its entire row and column = 0

// 🔴 Step 0: Main difficulty

// If you start changing matrix immediately:

// New zeros will appear
// You won’t know which zeros were original
// 👉 Result becomes wrong
// 🔹 Step 1: So we separate work into 2 phases
// ✅ Phase 1 → Mark

// 👉 Just remember which rows/columns should be zero

// ✅ Phase 2 → Apply

// 👉 Actually convert cells to zero

// 🔹 Step 2: Where to store marks?

// We need to remember:

// rows to zero
// columns to zero
// ❌ Normal way:
// row[m], col[n]

// → extra space

// ✅ Smart way (optimal):

// 👉 Use first row & first column as storage

// matrix[i][0] = 0 → mark row i
// matrix[0][j] = 0 → mark column j
// 🔹 Step 3: Marking phase

// Traverse whole matrix:

// If:

// matrix[i][j] == 0

// Then:

// matrix[i][0] = 0;   // mark row
// matrix[0][j] = 0;   // mark column

// 👉 No actual zeroing yet — only marking

// 🔹 Step 4: Applying phase

// Now for every cell (i,j) (except first row/col):

// Check:

// if (matrix[i][0] == 0 || matrix[0][j] == 0)

// 👉 If row OR column marked → make it 0

// 🔹 Step 5: Special case (VERY IMPORTANT)

// What if:

// first row itself had a 0?
// first column itself had a 0?

// 👉 Then markers get mixed up

// So we store separately:

// boolean firstRow, firstCol;
// 🔹 Full flow in mind

// 👉 Scan matrix
// → mark rows & columns using first row/col

// 👉 Scan again
// → use marks to update cells

// 👉 Finally
// → handle first row & first column separately

// 🔹 Visual summary

// Original:

// 1 1 1
// 1 0 1
// 1 1 1

// After marking:

// 1 0 1
// 0 0 1
// 1 1 1

// After applying:

// 1 0 1
// 0 0 0
// 1 0 1
// 🔹 Why this is optimal
// No extra arrays
// Uses matrix itself as memory
// Time: O(m × n)
// Space: O(1)