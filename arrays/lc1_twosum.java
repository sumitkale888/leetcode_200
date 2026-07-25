class Solution {
    public int[] twoSum(int[] nums, int target) {
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                if((nums[i]+nums[j])==target){
                    return new int[]{i,j};
                }
            }
        }
        return new int[]{0,0};
    }
}

class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n=nums.length;
        HashMap<Integer,Integer>map=new HashMap<>();
        for(int i=0;i<n;i++){
            int comp=target-nums[i];

            if(map.containsKey(comp)){
                return new int[]{map.get(comp),i};
            }

            map.put(nums[i],i);
        }
        return new int[]{-1,-1};
        
    }
}
// Algorithm:

// Traverse the array once.
// For each element nums[i], compute complement = target - nums[i].
// If the complement is already in the HashMap, return the two indices.
// Otherwise, store the current number and its index in the HashMap.

// Example:

// nums = [2, 7, 11, 15]
// target = 9

// i = 0
// num = 2
// complement = 7
// HashMap = {}
// Store 2 -> 0

// i = 1
// num = 7
// complement = 2
// HashMap contains 2
// Answer = [0, 1]