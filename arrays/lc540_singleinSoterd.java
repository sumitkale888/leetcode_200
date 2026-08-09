class Solution {
    public int singleNonDuplicate(int[] nums) {
        if(nums.length==1)return nums[0];

        for(int i=0;i<nums.length;i++){
            if(i==0){
                if(nums[i]!=nums[i+1])return nums[i];
            }else if(i==nums.length-1){
                if(nums[i]!=nums[i-1])return nums[i];
            }else{
                if(nums[i]!=nums[i-1]&&nums[i]!=nums[i+1]){
                    return nums[i];
                }
            }
        }
        return -1;
        
    }
}

class Solution {
    public int singleNonDuplicate(int[] nums) {
        if(nums.length==1)return nums[0];
        int n=nums.length;
        if(nums[0]!=nums[1])return nums[0];
        if(nums[n-1]!=nums[n-2])return nums[n-1];

        int s=1;
        int e=n-2;
        while(s<=e){
            int mid=s+(e-s)/2;

            if(nums[mid]!=nums[mid-1]&&nums[mid]!=nums[mid+1]){
                return nums[mid];
            }
            if((mid%2==0&&nums[mid]==nums[mid+1])||
                mid%2==1&&nums[mid]==nums[mid-1]){
                    s=mid+1;
                }else{
                    e=mid-1;
                }
        }
return -1;
        
    }
}

// Before the single element, pairs follow (even, odd) indexes.
// After the single element, pairs become (odd, even) because the single element shifts the indexes.
// If mid is paired with its expected neighbor, the single element is on the right.
// If the pair is broken, the single element is on the left.