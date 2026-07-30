public class lc26_removeduplicates {
    
}

class Solution {
    public int removeDuplicates(int[] nums) {
            int j=0;
        for(int i=1;i<nums.length;i++){
             if(nums[i]!=nums[j]){
                j++;
                nums[j]=nums[i];
                    
             }
           
        }
        return j+1;
        
    }
}


// The intuition is that the array is already sorted, so all duplicate values are next to each other.

// Your code uses two pointers:

// j → points to the last unique element.
// i → scans the array from left to right.
// Idea

// Whenever nums[i] is different from nums[j], you've found a new unique element.

// So:

// Move j one step forward.
// Store this new unique element at nums[j].

// This keeps all unique elements together at the beginning of the array.