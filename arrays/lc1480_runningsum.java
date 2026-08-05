public class lc1480_runningsum {
    
}
class Solution {
    public int[] runningSum(int[] nums) {
        int psum = 0;

        for (int i = 0; i < nums.length; i++) {
            psum += nums[i];
            nums[i] = psum;
        }

        return nums;
    }
}