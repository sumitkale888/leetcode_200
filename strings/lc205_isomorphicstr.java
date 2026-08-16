public class lc205_isomorphicstr {
    
}
class Solution {
    public boolean isIsomorphic(String s, String t) {
        if(s.length()!=t.length()){
            return false;
        }
        HashMap<Character,Character>map1=new HashMap<>();
        HashMap<Character,Character>map2=new HashMap<>();
        for(int i=0;i<s.length();i++){
           char a=s.charAt(i);
           char b=t.charAt(i);

           if(map1.containsKey(a)&&map1.get(a)!=b){
            return false;
           }
             if(map2.containsKey(b)&&map2.get(b)!=a){
            return false;
           }
           map1.put(a,b);
           map2.put(b,a);
        }
        
        return true;
    }
}

// Every character must consistently map to exactly one character,
//  and every target character must come from exactly one source character."

// Let's dry run your code with:

// s = "egg"
// t = "add"
// Initial
// map1 = {}    // s → t
// map2 = {}    // t → s
// i = 0
// a = 'e'
// b = 'a'

// Check:

// map1.containsKey('e')  → false
// map2.containsKey('a')  → false

// Store:

// map1 = {e → a}
// map2 = {a → e}
// i = 1
// a = 'g'
// b = 'd'

// Check:

// map1.containsKey('g')  → false
// map2.containsKey('d')  → false

// Store:

// map1 = {e → a, g → d}
// map2 = {a → e, d → g}
// i = 2
// a = 'g'
// b = 'd'

// Now g already exists:

// map1.containsKey('g') → true
// map1.get('g') → 'd'

// Compare:

// 'd' != 'd' → false

// So no error.

// Similarly:

// map2.containsKey('d') → true
// map2.get('d') → 'g'


// 'g' != 'g' → false

// Store again:

// map1 = {e → a, g → d}
// map2 = {a → e, d → g}

// Loop ends.

// return true;
// Final result
// "egg" → "add"
//        ↓
//      true

// The important thing is that when a character appears again, its old mapping must be exactly the same.