class Solution {
    public void solveSudoku(char[][] board) {
        solve(board);
        
    }
    public boolean solve(char[][]board){
        for(int r=0;r<9;r++){
            for(int c=0;c<9;c++){
                if(board[r][c]!='.'){
                    for(char ch='1';ch<='9';ch++){
                        if(safe(board,r,c,ch)){
                            board[r][c]=ch;
                            if(solve(board)){
                                return true;
                            }else{
                                board[r][c]='.';
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
    public boolean safe(char[][]board,int r,int col,char c){
        for(int i=0;i<9;i++){
            if(board[i][col]==c)return false;
            if(board[r][i]==c)return false;

            if(board[3*(r/3)+i/3][3*(col/3)+i%3]=='c')return false;
        }
        return true;
    }
}


// Full intuition of Sudoku Solver (Backtracking)

// The goal is simple:
// 👉 Fill all empty cells (.) so that:

// Each row has 1–9 (no duplicates)
// Each column has 1–9
// Each 3×3 box has 1–9
// Core idea

// You don’t know the correct number directly, so you:

// Try → Check → Go deeper → If wrong → Undo

// How the algorithm actually thinks
// Step 1: Find an empty cell

// Loop through the board:

// if(board[r][c] == '.')

// 👉 “This cell needs a number”

// Step 2: Try all possibilities (1–9)
// for(char ch = '1'; ch <= '9'; ch++)

// 👉 “Let me try every number”

// Step 3: Check if it’s safe
// if(safe(board, r, c, ch))

// Safe means:

// Not in same row
// Not in same column
// Not in same 3×3 box

// 👉 “Does this number violate rules?”

// Step 4: Place the number (choice)
// board[r][c] = ch;

// 👉 “Assume this is correct”

// Step 5: Solve rest of board (recursion)
// if(solve(board)) return true;

// 👉 “If the rest of the board works, we are done”

// Step 6: If it fails → backtrack
// board[r][c] = '.';

// 👉 “This number was wrong, remove it”

// Step 7: If no number works
// return false;

// 👉 “This path is invalid, go back”

// How recursion flows (important)

// Think like this:

// You fill one cell
// Then next
// Then next
// Suddenly stuck ❌

// So:

// Go back one step
// Change that value
// Try again
// Visual thinking

// Instead of one path, imagine a tree:

// Cell 1 → try 1
//         → try 2
//         → try 3
//              ↓
//         Cell 2 → try 1
//                 → try 2
//                 → fail ❌
//              ↑
//         try next option

// 👉 It explores all paths until one works

// Why it works
// It systematically tries all valid combinations
// Stops immediately when solution is found
// Eliminates invalid paths early using safe()
// Key intuition (most important)

// You are not solving Sudoku directly.
// You are searching for a valid configuration.

// Pattern to remember

// Backtracking =

// Choose
// Explore
// Undo
// One line

// Try every number, go forward if valid, go back if stuck, repeat until solved.

// isssafe function that last part of 3 multyply devide

// You’re asking about this part:

// board[3*(r/3) + i/3][3*(col/3) + i%3]

// This is used to check the 3×3 subgrid (box).

// Intuition

// Sudoku board has 9 boxes:
// Each box is 3×3.

// We need to:
// 👉 Find which box (r, col) belongs to
// 👉 Then loop through all 9 cells of that box

// Step 1: Find starting point of box
// 3 * (r / 3)
// 3 * (col / 3)
// Example:

// If r = 5, col = 7

// r / 3 = 1 → 3 * 1 = 3
// col / 3 = 2 → 3 * 2 = 6

// 👉 Box starts at (3,6)

// Step 2: Traverse inside the box

// We use one loop i = 0 → 8 and convert it into 2D:

// row = startRow + i/3
// col = startCol + i%3
// Why i/3 and i%3?
// i	i/3	i%3	Position
// 0	0	0	(0,0)
// 1	0	1	(0,1)
// 2	0	2	(0,2)
// 3	1	0	(1,0)
// 4	1	1	(1,1)
// 5	1	2	(1,2)
// 6	2	0	(2,0)
// 7	2	1	(2,1)
// 8	2	2	(2,2)

// 👉 This covers entire 3×3 box

// Final meaning
// board[3*(r/3) + i/3][3*(col/3) + i%3]

// 👉 “Check every cell inside the 3×3 box of (r, col)”

// Simple words
// r/3, col/3 → find box number
// *3 → get starting index
// i/3, i%3 → move inside box