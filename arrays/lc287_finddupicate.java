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