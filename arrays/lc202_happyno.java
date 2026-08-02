public class lc202_happyno {
    
}
class Solution {
    public boolean isHappy(int n) {
        HashSet<Integer>s=new HashSet<>();
        while(true){
            int sum=0;
            while(n!=0){
             sum+=Math.pow(n%10,2);
             n/=10;
        }
        if(sum==1)return true;

        n=sum;
        if(s.contains(n)){
            return false;
        }
        s.add(n);
        }
      
        
    }
}