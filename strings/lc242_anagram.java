class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;

        int[] count = new int[26];

        for(int i = 0; i < s.length(); i++){
            count[s.charAt(i) - 'a']++;
            count[t.charAt(i) - 'a']--;
        }

        for(int num : count){
            if(num != 0) return false;
        }

        return true;
    }
}

// The Valid Anagram problem (LeetCode 242) asks whether two strings contain the same characters with the same frequencies.
// Time: O(n)
// Space: O(1) (array size is fixed at 26)

// Step 1: Why charAt(i) - 'a'?

// Characters have ASCII/Unicode values.