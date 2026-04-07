// brutforce solution

class Solution {
    public int totalFruit(int[] fruits) {
        
        int n=fruits.length;
        int max=0;
        for(int i=0;i<n;i++){
            Set<Integer>s=new HashSet<>();
            for(int j=i;j<n;j++){
                
                 s.add(fruits[j]);
                if(s.size()<=2){
                    max=Math.max(max,j-i+1);
                }else{
                    break;
                }
            }
        }
        return max;
        
    }
}

class Solution {
    public int totalFruit(int[] fruits) {
        
        int n=fruits.length;
        int max=0;
        int l=0;
        HashMap<Integer,Integer>m=new HashMap<>();

       for(int r=0;r<n;r++){
        if(m.containsKey(fruits[r])){
            m.put(fruits[r],m.get(fruits[r])+1);
        }else{
            m.put(fruits[r],1);
        }

        while(m.size()>2){
            m.put(fruits[l],m.get(fruits[l])-1);
            if(m.get(fruits[l])==0){m.remove(fruits[l]);}
            l++;
        }
        max=Math.max(max,r-1+1);

       }
       return max;
       
       
        
    }
}

// ✔️ Intuition (Sliding Window)
// You have 2 baskets → at most 2 fruit types allowed
// You want the longest continuous subarray satisfying this
// 🔹 Core Idea
// Expand window using r (right pointer)
// Keep track of fruit counts using HashMap
// If more than 2 types → shrink from left (l)
// 🔹 How it works step by step
// Move r forward → add fruit to map
// If map size ≤ 2 → valid window
// If map size > 2 →
// move l forward
// reduce count of fruits
// remove when count becomes 0
// At every step → update max window length
// 🔹 Why this works
// You always maintain a valid window (≤2 types)
// You try to make it as large as possible
// If invalid → shrink just enough to fix it
// 🔹 Visual thinking

// Think like:

// “Take fruits continuously”
// “If I pick a 3rd type → start dropping from left until only 2 types remain”