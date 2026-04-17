class Solution {
    public int reverseBits(int n) {
        if(n==0)return 0;
        int res=0;
        for(int i=1;i<=32;i++){
         res=res<<1;
            res=res|(n&1);
            n=n>>1;
        }
        return res;
        
    }
}


// Take the last bit of n
// Put it at the front of result
// Repeat for all 32 bits
// How it works step by step
// (n & 1) → gives the last bit of n
// res << 1 → makes space on right side of result
// res | (n & 1) → inserts extracted bit
// n >> 1 → removes last bit of n
// Visualization
// n      = 1011
// res    = 0000

// Step 1: take 1 → res = 0001
// Step 2: take 1 → res = 0011
// Step 3: take 0 → res = 0110
// Step 4: take 1 → res = 1101

// So bits are picked from right → built on left


//  res=res<<1;
//  make place for last 1 from n if res has 1 at last bit


//  res=res|(n&1);
//  add that 1 to res 

//   n=n>>1;
//   decrease the no bit by bit