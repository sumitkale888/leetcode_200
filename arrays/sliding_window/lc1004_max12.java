public class lc1004_max12 {
    
}
class Solution {
    public int longestOnes(int[] nums, int k) {
       int m=0;
       int z=0;
       int left=0;
       for(int r=0;r<nums.length;r++){
        if(nums[r]==0)z++;
        while(z>k){
            if(nums[left]==0)z--;
            left++;
        }
        m=Math.max(m,r-left+1);
       }
       return m;
        
    }
}


// Think like this:

// You can convert at most k zeros → 1.
// So your window can contain at most k zeros.
// Expand the window (right++).
// If zeros become more than k, move left until zeros ≤ k again.
// Track the maximum window size.

// Rule:

// zeros ≤ k  → window valid  
// zeros > k  → move left