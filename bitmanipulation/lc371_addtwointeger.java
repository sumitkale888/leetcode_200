class Solution {
    public int getSum(int a, int b) {
        while(b!=0){
        int carry=(a&b)<<1;
           a=a^b;
           b=carry;}
           return a;
        
    }
    
}
// Sum of Two Integers

// Goal: Add two integers without using + or -.

// Core Intuition

// Addition has two parts:

// Sum without carry
// Carry

// Bit operations can simulate both.

// 1️⃣ Sum without Carry → XOR

// ^ behaves like addition without carry.

// Example:

// a = 5  → 0101
// b = 3  → 0011
// 0101
// 0011
// ----
// 0110   (XOR)

// This gives 6, but actual answer is 8, because we ignored carry.

// 2️⃣ Carry → AND + Left Shift

// Carry happens where both bits are 1.

// Use:

// (a & b) << 1

// Example:

// 0101
// 0011
// ----
// 0001  (AND)

// 0001 << 1 = 0010

// Carry = 2

// Combine Both
// sum = a ^ b
// carry = (a & b) << 1

// Now add again:

// sum + carry

// But again without +, so repeat until carry = 0.

// Dry Run

// Example:

// a = 5
// b = 3

// Step 1

// sum = a ^ b = 6
// carry = (a & b) << 1 = 2

// Step 2

// a = 6
// b = 2

// sum = 6 ^ 2 = 4
// carry = (6 & 2) << 1 = 4

// Step 3

// a = 4
// b = 4

// sum = 0
// carry = 8

// Step 4

// a = 0
// b = 8

// sum = 8
// carry = 0

// Stop.

// Answer:

// 8