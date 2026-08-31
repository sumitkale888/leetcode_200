public enum lc557_revWords {
    
}
class Solution {
    public String reverseWords(String s) {
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<s.length();i++){
            int j=i;
            while(j<s.length()&&s.charAt(j)!=' '){
                j++;
            }
            for(int k=j-1;k>=i;k--){
                sb.append(s.charAt(k));
            }

            if(j<s.length()) sb.append(' ');
           
            i=j;
            
        }
        return sb.toString();
    }
    
}