public class lc724_finfpivot {
    
}
class Solution {
    public int pivotIndex(int[] nums) {

        for (int i = 0; i < nums.length; i++) {

            int leftSum = 0;
            int rightSum = 0;

            // Left sum
            for (int j = 0; j < i; j++) {
                leftSum += nums[j];
            }

            // Right sum
            for (int j = i + 1; j < nums.length; j++) {
                rightSum += nums[j];
            }

            if (leftSum == rightSum) {
                return i;
            }
        }

        return -1;
    }
}


class Solution {
    public int pivotIndex(int[] nums) {
        int rsum=0;
        for(int i=0;i<nums.length;i++){
            rsum+=nums[i];
        }
        int lsum=0;
        for(int i=0;i<nums.length;i++){
            rsum=rsum-nums[i];
            if(lsum==rsum){
                return i;
            }
            lsum+=nums[i];
        }

        return -1;
        
    }
}

// Core Intuition

// Instead of calculating left and right sums repeatedly:

// Find the total sum of the array.
// Maintain a running left sum.
// Compute the right sum using:
// rightSum = totalSum - leftSum - nums[i]

// because:

// totalSum
// = leftSum + nums[i] + rightSum

// Rearranging gives:

// rightSum = totalSum - leftSum - nums[i]

// If:

// leftSum == rightSum

// then i is the pivot index.

// Finally, update:

// leftSum += nums[i]

// and move to the next index.