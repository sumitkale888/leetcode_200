class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res=new ArrayList<>();
       char[][]bord=new char[n][n];
       for(char[]c:bord){
        Arrays.fill(c,'.');
       }
        
        backtrack(0,bord,res,n);
        return res;
    }
    public void backtrack(int row,char[][]bord, List<List<String>> res,int n){
        if(row==n){
            res.add(construct(bord));
            return;
        }
        for(int c=0;c<n;c++){
            if(safe(bord,row,c,n)){
                bord[row][c]='Q';
                backtrack(row+1,bord,res,n);
                bord[row][c]='.';
            }
        }
    }
    public boolean safe(char[][]bord,int r,int c,int n){
        for(int i=0;i<r;i++){
            if(bord[i][c]=='Q'){
                return false;
            }
        }
        for(int i=0;i<c;i++){
            if(bord[r][i]=='Q'){
                return false;
            }
        }
        for(int i=r-1,j=c-1;i>=0&&j>=0;i--,j--){
            if(bord[i][j]=='Q'){
                return false;
            }
        }
         for(int i=r-1,j=c+1;i>=0&&j<n;i--,j++){
            if(bord[i][j]=='Q'){
                return false;
            }
        }
        return true;
    }
    public List<String>construct(char[][]bord){
        List<String>l=new ArrayList<>();
        for(char[]c:bord){
            l.add(new String(c));
        }
        return l;
    }
}

// We’ll follow the exact code flow step-by-step so you can see where recursion + backtracking happens.

// 🔑 Code (focus lines)
// for (int col = 0; col < n; col++) {

//     if (isSafe(board, row, col, n)) {

//         board[row][col] = 'Q';           // ✅ place

//         backtrack(row + 1, board, res, n); // 👉 go next row

//         board[row][col] = '.';           // 🔁 backtrack (undo)
//     }
// }
// 🟢 Start

// Call:

// backtrack(0, board)

// Board empty.

// 🔹 Step 1 → row = 0

// Loop runs:

// col = 0 → safe
// board[0][0] = 'Q';
// backtrack(1)

// Board:

// Q . . .
// . . . .
// . . . .
// . . . .
// 🔹 Step 2 → row = 1

// Loop:

// col 0 ❌ (same column)
// col 1 ❌ (diagonal)
// col 2 ✅
// board[1][2] = 'Q';
// backtrack(2)

// Board:

// Q . . .
// . . Q .
// . . . .
// . . . .
// 🔹 Step 3 → row = 2

// Try all cols → all ❌

// So loop ends → function returns

// 👉 control goes back here:

// board[1][2] = '.';   // 🔁 BACKTRACK

// Board becomes:

// Q . . .
// . . . .
// . . . .
// . . . .
// 🔹 Step 4 → row = 1 (continue loop)

// Now:

// col 3 ✅
// board[1][3] = 'Q';
// backtrack(2)
// 🔹 Step 5 → row = 2
// col 1 ✅
// board[2][1] = 'Q';
// backtrack(3)

// Board:

// Q . . .
// . . . Q
// . Q . .
// . . . .
// 🔹 Step 6 → row = 3

// All cols ❌

// 👉 return → backtrack:

// board[2][1] = '.';  // 🔁

// Then row 2 tries next → all fail
// 👉 backtrack again:

// board[1][3] = '.';  // 🔁

// Then row 1 ends
// 👉 backtrack again:

// board[0][0] = '.';  // 🔁
// 🔥 IMPORTANT PATTERN

// Every time:

// Place 'Q'
// Go deeper (backtrack)
// If fail → return
// Undo ('.') ← THIS is backtracking
// 🔹 Now new path
// row 0 → col 1
// board[0][1] = 'Q';
// backtrack(1)

// Follow same steps → finally reach:

// . Q . .
// . . . Q
// Q . . .
// . . Q .

// 👉 row == n → solution added

// 🧠 What you should understand
// Each recursive call = next row
// Loop = trying all columns
// isSafe = filter invalid moves
// board[row][col] = '.' = undo step