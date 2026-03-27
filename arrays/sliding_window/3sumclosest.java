class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int ressum=nums[0]+nums[1]+nums[2];
        int min=Integer.MAX_VALUE;
        for(int i=0;i<nums.length-2;i++){
            int l=i+1;
            int r=nums.length-1;
            while(l<r){
                int sum=nums[i]+nums[l]+nums[r];
                if(sum==target){
                    return sum;
                }
                if(sum<target){
                    l++;
                }else{
                    r--;
                }
                int totaldiff=Math.abs(sum-target);
                if(totaldiff<min){
                    ressum=sum;
                    min=totaldiff;
                }
            }
        }
        return ressum;
    }
}