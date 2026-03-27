class Solution {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder sb=new StringBuilder();
        Arrays.sort(strs);
        char[] first=strs[0].toCharArray();
         char[] last=strs[strs.length-1].toCharArray();

         for(int i=0;i<first.length;i++){
            if(first[i]==last[i]){
                sb.append(first[i]);
            }else{
                break;
            }
         }
         return sb.toString();
    }
}
//sort the string arr
//take first and last word in char arr
//matching in first and last is longest prefix