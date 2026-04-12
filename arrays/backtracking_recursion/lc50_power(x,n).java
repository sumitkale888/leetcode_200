// if(n == 0) return 1;

// if(n < 0){
//     return 1 / myPow(x, -n);
// }

// return x * myPow(x, n - 1);




// log n

class Solution {
    public double myPow(double x, int n) {
        long N=n;
        if(N<0){
            x=1/x;
            N=-N;

        }

        double ans=1;
        while(N>0){
            if(N%2==1){
                ans=ans*x;
            }
            x=x*x;
            N=N/2;
        }
        return ans;
       
        
    }
    
}
// Code being used
// double ans = 1;

// while(N > 0){
//     if(N % 2 == 1){
//         ans = ans * x;
//     }
//     x = x * x;
//     N = N / 2;
// }
// 🧪 Example: x = 2, n = 5

// Initial:

// x = 2, N = 5, ans = 1
// 🔴 Step 1 (N = 5 → odd)
// ans = 1 * 2 = 2
// x = 2 * 2 = 4
// N = 5 / 2 = 2
// 🟢 Step 2 (N = 2 → even)
// ans = 2   (no change)
// x = 4 * 4 = 16
// N = 2 / 2 = 1
// 🔴 Step 3 (N = 1 → odd)
// ans = 2 * 16 = 32
// x = 16 * 16 = 256
// N = 1 / 2 = 0
// ⛔ Stop (N = 0)
// ✅ Final Answer
// ans = 32
// 🔑 What happened internally
// 2^5
// = 2 × (2^4)
// = 2 × (2^2 × 2^2)
// = 2 × (4 × 4)
// = 32
// ⚡ Key observation
// Odd → take one x into answer
// Even → just square and reduce