public class lc424_longrepReplace {
    
}
class Solution {
    public int characterReplacement(String s, int k) {
        int[] freq=new int[26];

        int maxf=0;
        int ans=0;
        int l=0;//left

        for(int r=0;r<s.length();r++){
            freq[s.charAt(r)-'A']++;

            maxf=Math.max(maxf,freq[s.charAt(r)-'A']);

            while((r-l+1)-maxf>k){
                freq[s.charAt(l)-'A']--;
                l++;
            }
            ans=Math.max(ans,(r-l+1));
        }
        return ans;
    }
}