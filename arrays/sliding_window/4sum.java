class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        int n=nums.length;
        Set<List<Integer>>res=new HashSet<>();
        for(int i=0;i<n-3;i++){
            for(int j=i+1;j<n-2;j++){
                int l=j+1;
                int r=n-1;
                while(l<r){
                    long sum=(long)nums[i]+nums[j]+nums[r]+nums[l];
                    if(sum==target){
                        res.add(Arrays.asList(nums[i],nums[j],nums[l],nums[r]));
                        l++;
                        r--;
                    }else if(sum<target){
                        l++;
                    }else{
                        r--;
                    }
                }
            }
        }
        return new ArrayList<>(res);
        
    }
}