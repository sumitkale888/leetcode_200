// sumit kale
// time comp n log n

class Solution {
    public int[] countBits(int n) {
        int[]res=new int[n+1];
      int k=0;
     
        for(int i=0;i<=n;i++){
             int c=0;
            int num=i;
            while(num!=0){
             c=c+(num&1);
             num=num>>1;
            }
            res[k++]=c;
            
        }
        return res;
        
        
    }
}

// dp solution o(n)
   for(int i=1;i<=n;i++){
        res[i]=res[i>>1]+(i&1);
    }
        return res;
        
//         Intuition (Simple)

// When we right shift a number (i >> 1), we remove the last bit.

// So the number of set bits in i is:

// set bits in i >> 1
// plus the last bit.

// So:

// bits(i) = bits(i >> 1) + last_bit

// Last bit is:

// i & 1

// So the formula becomes:

// bits(i) = bits(i >> 1) + (i & 1)
// Example

// Take 5

// Binary:

// 5 = 101

// Remove last bit:

// 5 >> 1 = 10 = 2

// Set bits in 2 = 1

// Last bit of 5:

// 5 & 1 = 1

// So:

// bits(5) = bits(2) + 1
//         = 1 + 1
//         = 2
// Another Example

// Number 6

// 6 = 110
// 6 >> 1 = 11 = 3

// Set bits in 3 = 2

// Last bit:

// 6 & 1 = 0

// So

// bits(6) = bits(3) + 0
//         = 2
// Why DP Works

// We already know results for smaller numbers.

// 0
// 1
// 2
// 3
// 4
// 5

// When computing 5, we already computed 2.

// So we reuse it.

// Pattern You Should Notice
// 0 → 0
// 1 → 1
// 2 → 1
// 3 → 2
// 4 → 1
// 5 → 2
// 6 → 2
// 7 → 3

// Each number depends on half of itself.

// That is why:

// i >> 1

// is used.

// Final Code
// for(int i = 1; i <= n; i++){
//     res[i] = res[i >> 1] + (i & 1);
// }

// ✅ One-line intuition (interview answer):

// When we right shift a number we remove the last bit, so the number of set bits equals the set bits of i/2 plus the last bit.
    