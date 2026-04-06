class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int n=nums.length;
        int sum=0;
        int left=0;
        int l=Integer.MAX_VALUE;
        for(int right=0;right<n;right++){
            sum=sum+nums[right];

            while(sum>=target){
                l=Math.min(l,right-left+1);
                sum=sum-nums[left];
                left++;
            }

        }
       return l==Integer.MAX_VALUE?0:l;

        
    }
}

// 👉 Goal: smallest window whose sum ≥ target

// Core Idea

// Think in two phases:

// 1. Expand (right pointer)
// Keep adding elements
// Try to reach or exceed target

// 👉 “Make window valid”

// 2. Shrink (left pointer)
// Once sum ≥ target:
// Try removing elements from left
// Keep shrinking while condition still holds

// 👉 “Make window as small as possible”

// Why this works
// All numbers are positive
// So:
// Expanding → sum increases
// Shrinking → sum decreases

// 👉 This makes behavior predictable (no backtracking needed)

// Visualization
// target = 7
// nums = [2,3,1,2,4,3]
// Expand → [2,3,1,2] → sum = 8 ✅
// Shrink → [3,1,2] → sum = 6 ❌ stop

// Again:

// Expand → [3,1,2,4] → sum = 10 ✅
// Shrink → [1,2,4] → sum = 7 ✅
// Shrink → [2,4] → sum = 6 ❌

// 👉 Minimum length found = 2

// Key Thinking Pattern

// 👉 “Grow to satisfy → shrink to optimize”

// When to use this pattern
// Subarray / substring
// Condition like:
// sum ≥ k
// at most k distinct
// at most k zeros