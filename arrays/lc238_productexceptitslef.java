public class lc238_productexceptitslef {
    
}

class Solution {
    public int[] productExceptSelf(int[] nums) {

        int n = nums.length;
        int[] res = new int[n];

        for (int i = 0; i < n; i++) {

            int product = 1;

            for (int j = 0; j < n; j++) {

                if (i != j) {
                    product *= nums[j];
                }
            }

            res[i] = product;
        }

        return res;
    }
}



class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n=nums.length;
        int[] res=new int[n];
        res[0]=1;
        for(int i=1;i<n;i++){
            res[i]=nums[i-1]*res[i-1];
        }

        int right=1;
        for(int i=n-1;i>=0;i--){
            res[i]=res[i]*right;//res[i]=left[i]*right[i];
            right=right*nums[i];
        }
        return res;
    }
}