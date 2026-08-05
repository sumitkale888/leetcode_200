package sliding_window;

public class lc977_sqrofsorted {
    
}

class Solution {
    public int[] sortedSquares(int[] nums) {
        int[]res=new int[nums.length];
        int k=nums.length-1;
        int i=0;
        int j=nums.length-1;
        while(i<=j){
            int pl=nums[i]*nums[i];
            int pr=nums[j]*nums[j];

            if(pl>pr){
                res[k--]=pl;
                i++;
            }
            else{
                res[k--]=pr;
                j--;
            }
           

        }
        return res;
        
    }
}
