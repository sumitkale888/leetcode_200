public class lc350_intersection2 {
    
}
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        
        HashMap<Integer,Integer>m=new HashMap<>();
        for(int n:nums1){
            if(m.containsKey(n)){
                m.put(n,m.get(n)+1);
            }else{
                m.put(n,1);
            }
        }
       int[] res=new int[Math.min(nums2.length,nums1.length)];
       int i=0;
       for(int n:nums2){
        if(m.getOrDefault(n,0)>0){
            
            
                res[i++]=n;
               m.put(n,m.get(n)-1);
            
        }
       }
       return Arrays.copyOf(res,i);


    }
}