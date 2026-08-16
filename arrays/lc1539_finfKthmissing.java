public class lc1539_finfKthmissing {
    
}
class Solution {
    public int findKthPositive(int[] arr, int k) {
        for(int i=0;i<arr.length;i++){
            if(arr[i]<=k){
                k++;
            }else{
                break;
            }
        }
        return k;
        
    }
}
// If the array contains a number less than or equal to my current k,
//  then that number is not missing, so increase k. Once I find a number greater than k, stop.

class Solution {
    public int findKthPositive(int[] arr, int k) {
     int low=0;
     int high=arr.length-1;

     while(low<=high){
        int mid=(low+high)/2;

        int missing=arr[mid]-(mid+1);

        if(missing<k){
            low=mid+1;
            
        }else{
            high=mid-1;
           
           

        }
     }
     return high+k+1;
        
    }
}