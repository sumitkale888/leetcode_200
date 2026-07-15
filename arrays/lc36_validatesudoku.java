class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<String>s=new HashSet<>();
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                char num=board[i][j];
                if(num=='.')continue;

                if(s.contains(num+"row"+i)||
                s.contains(num+"col"+j)||
                s.contains(num+"box"+(i/3)+"-"+(j/3))){
                    return false;
                }
                s.add(num+"row"+i);
                 s.add(num+"col"+j);
                  s.add(num+"box"+(i/3)+"-"+(j/3));
                
            }
        }
        return true;
    }
}



// number row , col and box me nahi aana chaiye
// isliye 3 condition he 
// pehle set lo us me number ko string ke sath add kaso jaise vo nu,ber kis row , kis col and kis box me he
// jb next elment add kaso to pehle check karo already exists he ya nahi

// box k liye 
// agr hm same box ka konsa bi sub box le aur use divide kare 3 se to same ans aata he 
// isliye i/3 and j/3