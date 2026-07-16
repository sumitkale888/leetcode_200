public class lc152_maxprodsubarrr {
    
}
class Solution {
    
    public int maxProduct(int[] nums) {
        int p=1;
    int max=Integer.MIN_VALUE;
       
        for(int i=0;i<nums.length;i++){
            p*=nums[i];
            max=Math.max(max,p);

            if(p==0)p=1;
        }
          p=1;
        for(int i=nums.length-1;i>=0;i--){
            p*=nums[i];
            max=Math.max(max,p);

             if(p==0)p=1;
        
        }
        return max;
       
        
    }
}
// Intuition Behind Your Solution (Prefix & Suffix Product)

// The main idea is:

// The maximum product subarray is broken only by 0 or by an odd number of negative numbers.

// So instead of checking every subarray, we calculate the product from both directions.

// Why scan from left to right?

// We keep multiplying elements to get the product of the current subarray.

// Product = nums[0] × nums[1] × ... × nums[i]

// If there are:

// Even number of negative numbers → the product becomes positive, which can be the maximum.
// Zero → the product becomes 0, so we reset and start a new subarray.
// Why scan from right to left?

// If a subarray has an odd number of negative numbers, one negative must be excluded to get the maximum positive product.

// There are only two possibilities:

// Exclude the prefix up to the first negative.
// Exclude the suffix from the last negative.

// A left-to-right scan naturally captures one possibility, while a right-to-left scan captures the other.

// By taking the maximum product from both scans, we cover all cases.

// Example
// nums = [-1, -2, -3]

// Left scan:

// -1
// 2
// -6
// Maximum = 2

// Right scan:

// -3
// 6
// -6
// Maximum = 6

// The answer is 6, obtained from the subarray [-2, -3].

// Why reset when the product becomes 0?

// Example:

// [2, 3, 0, -2, 4]

// After reaching 0:

// 2 × 3 × 0 = 0

// Any further multiplication remains 0:

// 0 × (-2) × 4 = 0

// So we reset the product to 1 and start a new subarray after the zero.

// Interview Intuition (Short)

// We maintain the cumulative product while traversing from both the left and the right. A zero breaks the product, so we restart after it. If there is an odd number of negative elements, the maximum product subarray is obtained by excluding either the prefix up to the first negative or the suffix after the last negative. A left-to-right scan captures one case, and a right-to-left scan captures the other. The maximum product seen in both traversals is the answer.

// Exclude the prefix up to the first negative.
// Exclude the suffix from the last negative.meaning

// This is the key idea behind the prefix/suffix approach.

// Suppose a subarray has an odd number of negative numbers.

// Example:

// [-1, 2, 3, -4, 5]

// There are 2 negatives (-1, -4), so the product is positive. No problem.

// Now consider:

// [-1, 2, 3, -4, 5, -6]

// There are 3 negatives (-1, -4, -6), so the product of the entire array is negative.

// To get the maximum positive product, we must remove one negative. There are only two ways to do this while keeping the subarray contiguous.

// 1. Exclude the prefix up to the first negative

// The first negative is -1.

// Remove everything from the start through -1.

// [-1, 2, 3, -4, 5, -6]
//  ↑
// Remove this

// Remaining subarray:
// [2, 3, -4, 5, -6]

// Now the remaining subarray has 2 negatives (-4, -6), so its product is positive.

// 2. Exclude the suffix from the last negative

// The last negative is -6.

// Remove everything from -6 to the end.

// [-1, 2, 3, -4, 5, -6]
//                    ↑
//             Remove this

// Remaining subarray:
// [-1, 2, 3, -4, 5]

// Now the remaining subarray has 2 negatives (-1, -4), so its product is also positive.

// Why only these two?

// // To make the product positive, you need to remove exactly one negative while keeping the subarray contiguous.