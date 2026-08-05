package sliding_window;

public class lc26_removedupsort {
    
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

        // Set<Integer>s=new HashSet<>();
        // for(int i=0;i<nums.length;i++){
        //     s.add(nums[i]);
        // }
        // int i=0;
        // for(int n:s){
        //     nums[i++]=n;
        // }
        // return s.size();
    }
}