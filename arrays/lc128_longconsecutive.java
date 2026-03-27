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