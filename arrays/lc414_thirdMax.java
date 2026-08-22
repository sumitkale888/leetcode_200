public class lc414_thirdMax {
    
}
class Solution {
    public int thirdMax(int[] nums) {
       Integer first=null;
       Integer second=null;
       Integer third=null;
       for(int n :nums){
        if(Integer.valueOf(n).equals(first)||
        Integer.valueOf(n).equals(second)||
        Integer.valueOf(n).equals(third)){
            continue;
        }
        if(first==null||n>first){
            third=second;
            second=first;
            first=n;
        }else if(second==null||n>second){
            third=second;
            second=n;
        }else if(third==null||n>third){
            third=n;
        }
       }
       return third==null?first: third;
        
    }
}