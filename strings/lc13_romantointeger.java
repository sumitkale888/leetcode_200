public class lc13_romantointeger {
    
}
class Solution {
    public int romanToInt(String s) {
      Map<Character,Integer>m=new HashMap<>();
      m.put('I',1);
      m.put('V',5);
      m.put('X',10);
      m.put('L',50);
      m.put('C',100);
     m.put('D',500);
    m.put('M',1000);


    int ans=0;
    for(int i=0;i<s.length();i++){
        if(i+1<s.length()&&(m.get(s.charAt(i))<m.get(s.charAt(i+1)))){
            ans-=m.get(s.charAt(i));
        }else{
            ans+=m.get(s.charAt(i));
        }
   

        
    } 

    return ans;


    }
}

// The intuition is based on how Roman numerals are written.

// Rule 1: Normally, values are added

// Most Roman numerals are written from largest to smallest, so you simply add them.

// Example:

// VIII = V + I + I + I
//      = 5 + 1 + 1 + 1
//      = 8
// MCL = M + C + L
//     = 1000 + 100 + 50
//     = 1150
// Rule 2: If a smaller value comes before a larger value, subtract it

// Sometimes a smaller numeral is placed before a larger one to indicate subtraction.

// Examples:

// IV = 5 - 1 = 4
// IX = 10 - 1 = 9
// XL = 50 - 10 = 40
// CM = 1000 - 100 = 900

// Notice the pattern:

// Smaller < Larger

// So instead of adding the smaller value, we subtract it.