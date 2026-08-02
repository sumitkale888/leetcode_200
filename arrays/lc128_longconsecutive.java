class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer>set=new HashSet<>();
        HashSet<Integer>start=new HashSet<>();
        
        for(int i=0;i<nums.length;i++){
            set.add(nums[i]);
        }
        int j=0;
        for(int num:set){
            if(!set.contains(num-1)){
              start.add(num);
                
            }


        }
        int max=0;
        for(int n:start){
            int curr=n;
            int l=1;
            while(set.contains(curr+1)){
                curr++;
                l++;
                
            }
            max=Math.max(max,l);
           

        }
        return max;
    }
}
// The key idea is:

// Instead of starting from every number, only start from numbers that can be the beginning of a sequence.

// This avoids checking the same sequence multiple times.

// Step 1: Store all numbers in a HashSet
// HashSet<Integer> set = new HashSet<>();

// Why?

// Because HashSet allows us to check if a number exists in O(1) time.

// Example:

// nums = [100,4,200,1,3,2]

// Set becomes:

// {100,4,200,1,3,2}
// Step 2: Find the starting points
// if (!set.contains(num - 1)) {
//     start.add(num);
// }
// Intuition

// A number is the start of a sequence if its previous number doesn't exist.