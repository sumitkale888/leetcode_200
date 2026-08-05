public class lc345_revvowels {
    
}

class Solution {
    public String reverseVowels(String s) {
        char[]arr=s.toCharArray();
        int i=0;
        int j=s.length()-1;
        while(i<j){
            if(!isvowel(arr[i])){
                i++;
            }else if(!isvowel(arr[j])){
                j--;
            }else{
                char t=arr[i];
                arr[i]=arr[j];
                arr[j]=t;
                i++;
                j--;
            }
           
            }
        
        return new String(arr);
    }
    public boolean isvowel(char c){
        if(c=='a'||c=='e'||c=='i'||c=='o'||c=='u'||
           c=='A'||c=='E'||c=='O'||c=='I'||c=='U'){
            return true;
           }
           return false;
    }
}