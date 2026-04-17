class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>>ans=new ArrayList<>();
         List<Integer>comb=new ArrayList<>();
         helper(candidates,0,target,ans,comb);
         return ans;
    }
    public void helper(int[]arr,int i,int t, List<List<Integer>>ans, List<Integer>comb){
        if(t==0){
            ans.add(new ArrayList<>(comb));
            return;
        
        }
        if(i==arr.length||t<0)return;

        comb.add(arr[i]);
        helper(arr,i,t-arr[i],ans,comb);
        
        comb.remove(comb.size()-1);
        helper(arr,i+1,t,ans,comb);

    }
}

// Think of it as a decision tree where at each index you decide:

// 👉 “Do I take this number or skip it?”
// 🔹 Core Idea

// You are building combinations step by step.

// At every element arr[i], you have only 2 choices:

// 1️⃣ Pick the number
// Add it to your combination
// Reduce target: t - arr[i]
// Stay at same index (i)
// 👉 because you can reuse it unlimited times
// 2️⃣ Skip the number
// Don’t take it
// Move to next index (i + 1)
// 🔹 When do you stop?
// ✅ Valid combination
// target == 0

// → add current list to answer

// ❌ Invalid path
// target < 0 OR i == arr.length

// → stop exploring

//                                (0,7,[])
//                              /           \
//                     pick 2 /             \ skip 2
//                            /               \
//                     (0,5,[2])           (1,7,[])
//                     /       \           /       \
//              pick 2         skip    pick 3      skip
//               /               \        /           \
//       (0,3,[2,2])        (1,5,[2]) (1,4,[3])    (2,7,[])
//         /      \           /   \      /   \        /    \
//    pick 2     skip    pick3  skip  pick3 skip   pick6  skip
//      /           \      |      |      |    |      |      |
// (0,1,[2,2,2]) (1,3,[2,2])   ❌     ❌     ❌   ❌  (2,1)  (3,7)
//    /    \        /    \                              /    \
//  ❌     ❌  (1,0,[2,2,3]) ✅                    ❌   (3,0,[7]) ✅


// (i, target)
//    /        \
// pick        skip
// (i, t-arr[i])  (i+1, t)