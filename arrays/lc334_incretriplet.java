brutforce


class Solution {
    public boolean increasingTriplet(int[] nums) {
        int n=nums.length;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                for(int k=j+1;k<n;k++){
                    if((nums[i]<nums[j])&&nums[j]<nums[k]){
                        return true;
                    }
                }
            }
        }
        return false;
        
    }
}

class Solution {
    public boolean increasingTriplet(int[] nums) {
      int f=Integer.MAX_VALUE;
        
    int s=Integer.MAX_VALUE;
    for(int n:nums){
        if(n<=f){
            f=n;
        }
        else if(n<=s){
            s=n;
        }else{
            return true;
        }

    }
    return false;
        
    }
}

// Intuition

// Maintain two numbers:

// first = smallest element seen so far.
// second = smallest element greater than first.

// As you traverse:

// If num is smaller than first, update first.
// Else if num is smaller than second, update second.

// Else, num is greater than both first and second, so you've found:

// first < second < num

// Return true.