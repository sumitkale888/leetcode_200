class Solution {
    public int divide(int dividend, int divisor) {
       if(dividend==divisor)return 1;

       boolean sign=true;
       if(dividend>=0&&divisor<0){
        sign=false;
       }else if(dividend<=0&&divisor>0){
        sign=false;
       }
        

        long n=Math.abs((long)dividend);
        long d=Math.abs((long)divisor);

        long ans=0;

        while(n>=d){
            int c=0;
            while(n>=(d<<(c+1))){
                c++;
            }
            ans=ans+(1<<c);
            n=n-(d<<c);
        }
        if(ans==(1<<31)&&sign==true){
            ans=Integer.MAX_VALUE;
        }
         if(ans==(1<<31)&&sign==false){
            ans=Integer.MIN_VALUE;
        }
        if(sign==false){
            ans= -ans;
        }
        return (int)ans;
    }
}

// Time Complexity
// The inner loop finds the maximum power of 2 such that d × 2^c ≤ n.
// This takes O(log n) time because c increases until the shifted divisor exceeds n.
// The outer loop subtracts the largest possible multiple of the divisor.
// Each iteration reduces n significantly (by at least half of its current value relative to the largest power-of-two multiple), so it runs at most O(log n) times.

// Therefore,

// Outer loop: O(log n)
// Inner loop: O(log n)

// Overall Time Complexity:

// O((logn)sqr

// )
// 	​
// For the given code, let's do a dry run for divide(24, 3).

// Initial Values
// dividend = 24
// divisor = 3
// Step 1: Check if both are equal
// if(dividend == divisor)
// 24 == 3 ? No
// Step 2: Find sign
// sign = true

// Both numbers are positive, so

// sign = true
// Step 3: Convert to absolute values
// n = abs(24) = 24
// d = abs(3) = 3
// quotient = 0
// First Iteration of Outer While

// Condition:

// while(n >= d)
// 24 >= 3 ✔
// Find maximum shift

// Start:

// cnt = 0

// Check inner while:

// 24 >= 3 << (0+1)
// 24 >= 6 ✔
// cnt = 1
// 24 >= 3 << (1+1)
// 24 >= 12 ✔
// cnt = 2
// 24 >= 3 << (2+1)
// 24 >= 24 ✔
// cnt = 3
// 24 >= 3 << (3+1)
// 24 >= 48 ✘
// Stop

// Final:

// cnt = 3
// Update quotient
// quotient += 1 << cnt
// 1 << 3 = 8
// quotient = 0 + 8 = 8
// Reduce dividend
// n -= d << cnt
// 3 << 3 = 24

// n = 24 - 24 = 0

// Current state:

// n	d	cnt	quotient
// 0	3	3	8
// Second Iteration

// Check:

// while(n >= d)

// 0 >= 3 ✘

// Loop ends.