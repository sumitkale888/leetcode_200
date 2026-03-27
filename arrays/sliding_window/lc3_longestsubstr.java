class Solution {
    public int lengthOfLongestSubstring(String s) {
      int left=0;
      int max=0;
      HashSet<Character>set=new HashSet<>();
      for(int right=0;right<s.length();right++){
        while(set.contains(s.charAt(right))){
            set.remove(s.charAt(left));
            left++;
        }
        set.add(s.charAt(right));
        max=Math.max(max,right-left+1);
      }
      return max;
    }
}


max consecutive 1s with at most k 0s


// class Solution {
//     public int longestOnes(int[] nums, int k) {
//        int m=0;
//        int z=0;
//        int left=0;
//        for(int r=0;r<nums.length;r++){
//         if(nums[r]==0)z++;
//         while(z>k){
//             if(nums[left]==0)z--;
//             left++;
//         }
//         m=Math.max(m,r-left+1);
//        }
//        return m;
        
//     }
// }