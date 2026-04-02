public class powof2 {
    
}
class Solution {
    public boolean isPowerOfTwo(int n) {
        if (n <= 0) return false;
        
        while (n % 2 == 0) {
            n /= 2;
        }
        
        return n == 1;
    }
}


class Solution {
    public boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }
}


// 🔹 Intuition

// Power of 2 numbers in binary look like:

// 1 → 0001
// 2 → 0010
// 4 → 0100
// 8 → 1000

// 👉 Only one 1 bit

// Now observe:

// n - 1 flips all bits after that single 1

// Example:

// n     = 8  → 1000
// n - 1 = 7  → 0111

// 👉 AND operation:

// 1000
// 0111
// -----
// 0000

// So,

// If a number has only one set bit → n & (n - 1) == 0

class Solution {
    public boolean isPowerOfFour(int n) {
        if (n <= 0) return false;
        
        while (n % 4 == 0) {
            n /= 4;
        }
        
        return n == 1;
    }
}