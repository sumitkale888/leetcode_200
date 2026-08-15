public class lc541_revstr2 {
    
}
class Solution {
    public String reverseStr(String s, int k) {
        char[]arr=s.toCharArray();

     for(int i=0;i<arr.length;i+=2*k){
        rev(arr,i,Math.min(i+k-1,arr.length-1));
     }
        return new String(arr);

        
    }
    public void rev(char[]arr,int i,int j){

        while(i<j){
        char t=arr[i];
        arr[i]=arr[j];
        arr[j]=t;
        i++;
        j--;
        }
    }
}