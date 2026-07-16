public class lc53_maxsubarrsum {
    
}
class Solution {
    public int maxSubArray(int[] nums) {
        int m=Integer.MIN_VALUE;
       int s=0;
        for(int i=0;i<nums.length;i++){
             
            
                s=s+nums[i];
                m=Math.max(m,s);


            if(s<0){
                s=0;
            }
        }
        return m;
        
    }
}

// Intuition

// Suppose you're building a subarray from left to right.

// At every element, you have two choices:

// Extend the current subarray
// Start a new subarray from the current element

// If the current running sum becomes negative, it will only reduce the sum of any future subarray.

// So it's always better to discard it and start fresh.

// We maintain a running sum while traversing the array. If the running sum becomes negative, it cannot 
// help increase the sum of any future subarray, so we discard it and start a new subarray from the next 
// element. Throughout the traversal, we keep track of the maximum sum encountered. This greedy approach is known
//  as Kadane's Algorithm.