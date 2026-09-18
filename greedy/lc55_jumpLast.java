package greedy;

public class lc55_jumpLast {
    
}

// You are given an integer array nums. You are initially positioned at the array's first index, and each element in the array represents your maximum jump length at that position.

// Return true if you can reach the last index, or false otherwise.

 

// Example 1:

// Input: nums = [2,3,1,1,4]
// Output: true
// Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
// Example 2:

// Input: nums = [3,2,1,0,4]
// Output: false
// Explanation: You will always arrive at index 3 no matter what. Its maximum jump length is 0, which makes it impossible to reach the last index.
class Solution {
    public boolean canJump(int[] nums) {
        int reachable=0;
        for(int i=0;i<nums.length;i++){
            if(i>reachable){
                return false;
            }
            reachable=Math.max(reachable,i+nums[i]);
        }
        return true;
    }
}

// Core idea

// reachable means:

// The farthest index I can reach using all the jumps I've considered so far.

// int reachable = 0;

// Initially, you're at index 0, so you can reach index 0.

// At every index i

// You first check:

// if (i > reachable) {
//     return false;
// }

// If i is greater than reachable, it means:

// "I cannot even reach this index, so there is no way to continue."

// Therefore, return false.

// Then:

// reachable = Math.max(reachable, i + nums[i]);

// If you can reach index i, you ask:

// "If I jump from i, how far can I reach?"

// That is:

// i + nums[i]

// Then keep the maximum of the old reachable position and this new position.