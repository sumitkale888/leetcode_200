//brutforce


class Solution {
    public int singleNumber(int[] nums) {
         Arrays.sort(nums);

        for (int i = 1; i < nums.length; i += 3) {
            if (nums[i] != nums[i-1]) {
                return nums[i-1];
            }
        }

        return nums[nums.length - 1];
    }
}
optimal
class Solution {
    public int singleNumber(int[] nums) {
        int ans=0;
         for(int i=0;i<32;i++){
            int c=0;
            for(int n:nums){
                c=c+((n>>i)&1);
            }
          if (c % 3 == 1) {
            ans |= (1 << i);
}
         }
         return ans;

    }
}
// Single Number II — Intuition

// Given:

// Every number appears 3 times

// Only one number appears once

// Core Idea

// Think bit by bit (0–31 bits).

// For each bit position:

// Count how many numbers have that bit = 1

// Since most numbers appear 3 times, their bits contribute in multiples of 3

// So:

// sum_of_bits % 3

// 0 → all bits came from numbers appearing 3 times

// 1 → the single number has that bit = 1

// Example
// nums = [2,2,3,2]

// Binary
// 2 = 010
// 2 = 010
// 3 = 011
// 2 = 010

// Count bits:

// Bit position	Count of 1s	mod 3
// bit0	1	1
// bit1	4	1
// bit2	0	0

// // Result bits → 011 = 3