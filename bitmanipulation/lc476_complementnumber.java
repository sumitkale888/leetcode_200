public class lc476_complementnumber {
    
}
class Solution {
    public int findComplement(int num) {
        int res=0;
        int i=0;
        while(num!=0){
            if((num&1)==0){
                res=res+1<<i;
            }
            i=i+1;;
            num=num>>1;
        }
        return res;
    }
}