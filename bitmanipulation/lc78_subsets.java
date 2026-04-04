class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>>ans=new ArrayList<>();
        int n=nums.length;
        int d=1<<n;

        for(int i=0;i<d;i++){
            List<Integer>res=new ArrayList<>();
            for(int j=0;j<n;j++){
                if((i&(1<<j))!=0){
                    res.add(nums[j]);
                }
            }
            ans.add(res);
        }
        return ans;
    }
}


// 🔹 What each variable means
// n → number of elements
// d = 1 << n → total subsets = 2ⁿ
// i → represents each subset (in binary form)
// j → checks each element
// 🔹 Core Idea

// Each number i (0 → 2ⁿ−1) is treated as a bitmask

// If j-th bit is ON → include nums[j]
// If j-th bit is OFF → skip
// 🔹 Example

// nums = [1,2,3], n = 3, d = 8

// i (binary)	Subset
// 000	[]
// 001	[1]
// 010	[2]
// 011	[1,2]
// 100	[3]
// 101	[1,3]
// 110	[2,3]
// 111	[1,2,3]

// 🔹 Time Complexity

// O(n × 2ⁿ)