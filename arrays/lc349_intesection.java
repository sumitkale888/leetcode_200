class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer>set1=new HashSet<>();
        HashSet<Integer>res=new HashSet<>();

        for(int n:nums1){
            set1.add(n);
        }
          for(int m:nums2){
           if(set1.contains(m)){
            res.add(m);
           }
        }
        int[]ans=new int[res.size()];
        int i=0;
        for(int n:res){
            ans[i++]=n;
        }
return ans;
            }
}