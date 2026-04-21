public class lc6_zigzag {
    
}
class Solution {
    public String convert(String s, int numRows) {
        String[]ans=new String[numRows];
        for(int i=0;i<ans.length;i++){
            ans[i]="";
        }
        int i=0;
        while(i<s.length()){
            for(int j=0;j<numRows&&i<s.length();j++){
                ans[j]+=s.charAt(i++);
            }
             for(int j=numRows-2;j>0&&i<s.length();j--){
                ans[j]+=s.charAt(i++);
            }
        }
        StringBuilder sb=new StringBuilder();
        for(int k=0;k<ans.length;k++){
            sb.append(ans[k]);
        }
        return sb.toString();
    }
}