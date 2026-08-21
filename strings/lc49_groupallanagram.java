public class lc49_groupallanagram {
    
}
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>>map=new HashMap<>();
        for(String s:strs){
            char[]arr=s.toCharArray();
            Arrays.sort(arr);

            String key=new String(arr);
            if(!map.containsKey(key)){
                map.put(key,new ArrayList<>());
            }
            map.get(key).add(s);
        }
        return new ArrayList<>(map.values());
    }
}

// If this type of anagram doesn't exist, create a new group. Otherwise, add the string to its existing group.

// Complexity

// If there are n strings and each string has maximum length k:

// Sorting each string: O(k log k)
// For n strings: O(n × k log k)
// HashMap operations: approximately O(1) average
// Space: O(n × k)