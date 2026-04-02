// public class 260_singlin03 {
    
// }Single Number III — Intuition (very simple)
// All numbers appear twice, except 2 numbers
// Same numbers cancel out in XOR
// 👉 x ^ x = 0
// Step 1: XOR all

// 👉 You get:

// a ^ b

// (only the two unique numbers remain)

// Step 2: Find a different bit
// In a ^ b, at least one bit is different
// Pick any set bit (usually rightmost)

// 👉 This bit tells:

// one number has 0
// other has 1
// Step 3: Split into 2 groups
// Group 1 → numbers with that bit = 0
// Group 2 → numbers with that bit = 1

// 👉 Duplicate numbers go in same group → cancel out
// 👉 Each group leaves one unique number

// Final idea
// XOR removes duplicates
// A single differing bit helps separate the two answers


class Solution {
    public int[] singleNumber(int[] nums) {
        int xor = 0;

        // Step 1: XOR of all elements
        for (int num : nums) {
            xor ^= num;
        }

        // Step 2: Get rightmost set bit
        int diff = xor & (xor - 1)^xor;    

        int a = 0, b = 0;

        // Step 3: Divide numbers into two groups
        for (int num : nums) {
            if ((num & diff) == 0) {
                a ^= num;
            } else {
                b ^= num;
            }
        }

        return new int[]{a, b};
    }
}


// Example

// Array:

// [1, 2, 1, 3, 2, 5]

// We already got:

// xor = 3 ^ 5 = 6 → 0110
// diff = 2 → 0010
// Now loop:
// num = 1 (0001)
// 0001 & 0010 = 0 → group A
// a = 0 ^ 1 = 1
// num = 2 (0010)
// 0010 & 0010 = 1 → group B
// b = 0 ^ 2 = 2
// num = 1 (0001)
// group A
// a = 1 ^ 1 = 0   (cancel)
// num = 3 (0011)
// 0011 & 0010 = 1 → group B
// b = 2 ^ 3 = 1
// num = 2 (0010)
// group B
// b = 1 ^ 2 = 3   (cancel pair)
// num = 5 (0101)
// 0101 & 0010 = 0 → group A
// a = 0 ^ 5 = 5
// Final result
// a = 5
// b = 3