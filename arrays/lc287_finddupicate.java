class Solution {
    static int findDuplicate(int[]nums){
         int i=0;
    while(i<nums.length){
        int correct=nums[i]-1;
        if(nums[i]<nums.length&&nums[i]!=nums[correct]){
            // swap
            int temp=nums[i];
            nums[i]=nums[correct];
            nums[correct]=temp;
        }
        else{
          i++;
        }
    }
     // find missing no
    for(int j=0;j<nums.length;j++){
        if(nums[j]!=j+1){
            return nums[j];
            
        }
        


    }
    return nums.length;
   
    }
    
}

class Solution {
    public int findDuplicate(int[] nums) {

        for (int i = 0; i < nums.length; i++) {

            int count = 0;

            for (int j = 0; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    count++;
                }
            }

            if (count > 1)
                return nums[i];
        }

        return -1;
    }
}

import java.util.HashSet;

class Solution {
    public int findDuplicate(int[] nums) {

        HashSet<Integer> set = new HashSet<>();

        for (int num : nums) {

            if (set.contains(num))
                return num;

            set.add(num);
        }

        return -1;
    }
}