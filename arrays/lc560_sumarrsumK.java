public class lc560_sumarrsumK {
    
}
class Solution {
    public int subarraySum(int[] nums, int k) {
        int c = 0;

        for (int i = 0; i < nums.length; i++) {
            int sum = 0;

            for (int j = i; j < nums.length; j++) {
                sum += nums[j];

                if (sum == k) {
                    c++;
                }
            }
        }

        return c;
    }
}
class Solution {
    public int subarraySum(int[] nums, int k) {

        HashMap<Integer,Integer>map=new HashMap<>();
        map.put(0,1);
        int c=0;
        int presum=0;
        for(int n:nums){
            presum+=n;

            if(map.containsKey(presum-k)){
                c=c+map.get(presum-k);
            }
            map.put(presum,map.getOrDefault(presum,0)+1);

        }
        return c;





       
    }
}