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


// // 🔹 What each variable means
// // n → number of elements
// // d = 1 << n → total subsets = 2ⁿ
// // i → represents each subset (in binary form)
// // j → checks each element
// // 🔹 Core Idea

// // Each number i (0 → 2ⁿ−1) is treated as a bitmask

// // If j-th bit is ON → include nums[j]
// // If j-th bit is OFF → skip
// // 🔹 Example

// // nums = [1,2,3], n = 3, d = 8

// // i (binary)	Subset
// // 000	[]
// // 001	[1]
// // 010	[2]
// // 011	[1,2]
// // 100	[3]
// // 101	[1,3]
// // 110	[2,3]
// // 111	[1,2,3]

// // 🔹 Time Complexity

// // O(n × 2ⁿ)



// # Subsets using Bit Manipulation

// ```java
// class Solution {
//     public List<List<Integer>> subsets(int[] nums) {
//         List<List<Integer>> ans = new ArrayList<>();
//         int n = nums.length;
//         int d = 1 << n;

//         for (int i = 0; i < d; i++) {
//             List<Integer> res = new ArrayList<>();

//             for (int j = 0; j < n; j++) {
//                 if ((i & (1 << j)) != 0) {
//                     res.add(nums[j]);
//                 }
//             }

//             ans.add(res);
//         }

//         return ans;
//     }
// }
// ```

// # Intuition

// For an array of `n` elements, every element has **2 choices**:

// * Include it in the subset.
// * Exclude it from the subset.

// So, the total number of subsets is:

// [
// 2^n
// ]

// Instead of generating subsets recursively, we use the binary representation of numbers from `0` to `2ⁿ - 1`.

// Each binary number tells us which elements to include.

// ---

// # Variables

// ```java
// int n = nums.length;
// ```

// Number of elements.

// Example:

// ```text
// nums = [1,2,3]

// n = 3
// ```

// ---

// ```java
// int d = 1 << n;
// ```

// `1 << n` means **2ⁿ**.

// Example:

// ```
// 1 << 3

// 0001

// ↓

// 1000

// = 8
// ```

// So,

// ```text
// d = 8
// ```

// We will generate subsets for numbers:

// ```text
// 0
// 1
// 2
// 3
// 4
// 5
// 6
// 7
// ```

// ---

// # Outer Loop

// ```java
// for (int i = 0; i < d; i++)
// ```

// `i` represents one subset.

// ```
// i = 0

// ↓

// 000

// i = 1

// ↓

// 001

// i = 2

// ↓

// 010

// ...

// i = 7

// ↓

// 111
// ```

// Each binary number represents one subset.

// ---

// # Inner Loop

// ```java
// for (int j = 0; j < n; j++)
// ```

// We check every bit of `i`.

// ```
// j = 0 → first element
// j = 1 → second element
// j = 2 → third element
// ```

// ---

// # Bit Check

// ```java
// if ((i & (1 << j)) != 0)
// ```

// This checks whether the **j-th bit** of `i` is set.

// ### Step 1

// ```java
// 1 << j
// ```

// Suppose

// ```
// j = 2

// 1 << 2

// 001

// ↓

// 100
// ```

// ---

// ### Step 2

// Perform AND (`&`)

// Suppose

// ```
// i = 5

// Binary:

// 101
// ```

// Check bit 2

// ```
// 101
// 100
// ---
// 100
// ```

// Result is not zero.

// So,

// ```
// nums[2]
// ```

// is included.

// ---

// Check bit 1

// ```
// 101
// 010
// ---
// 000
// ```

// Result is zero.

// So,

// ```
// nums[1]
// ```

// is not included.

// ---

// Check bit 0

// ```
// 101
// 001
// ---
// 001
// ```

// Result is non-zero.

// So,

// ```
// nums[0]
// ```

// is included.

// Subset becomes

// ```
// [1,3]
// ```

// ---

// # Complete Example

// ```
// nums = [1,2,3]
// ```

// ---

// ## i = 0

// Binary

// ```
// 000
// ```

// Bit 0 = 0

// Bit 1 = 0

// Bit 2 = 0

// Subset

// ```
// []
// ```

// ---

// ## i = 1

// Binary

// ```
// 001
// ```

// Bit 0 = 1

// Include

// ```
// 1
// ```

// Bit 1 = 0

// Skip

// Bit 2 = 0

// Skip

// Subset

// ```
// [1]
// ```

// ---

// ## i = 2

// Binary

// ```
// 010
// ```

// Bit 0 = 0

// Skip

// Bit 1 = 1

// Include

// ```
// 2
// ```

// Bit 2 = 0

// Skip

// Subset

// ```
// [2]
// ```

// ---

// ## i = 3

// Binary

// ```
// 011
// ```

// Bit 0 = 1

// Include

// ```
// 1
// ```

// Bit 1 = 1

// Include

// ```
// 2
// ```

// Bit 2 = 0

// Skip

// Subset

// ```
// [1,2]
// ```

// ---

// ## i = 4

// Binary

// ```
// 100
// ```

// Subset

// ```
// [3]
// ```

// ---

// ## i = 5

// Binary

// ```
// 101
// ```

// Subset

// ```
// [1,3]
// ```

// ---

// ## i = 6

// Binary

// ```
// 110
// ```

// Subset

// ```
// [2,3]
// ```

// ---

// ## i = 7

// Binary

// ```
// 111
// ```

// Subset

// ```
// [1,2,3]
// ```

// ---

// # Final Output

// ```
// [
//  [],
//  [1],
//  [2],
//  [1,2],
//  [3],
//  [1,3],
//  [2,3],
//  [1,2,3]
// ]
// ```

// ---

// # Why does this work?

// Each bit represents whether an element is included.

// ```
// Bit = 1 → Include the element.

// Bit = 0 → Exclude the element.
// ```

// For `n` elements, there are exactly `2ⁿ` different bit patterns.

// Each bit pattern corresponds to one unique subset.

// ---

// # Time Complexity

// There are `2ⁿ` subsets.

// For each subset, we check `n` bits.

// ```
// Time = O(n × 2ⁿ)
// ```

// # Space Complexity

// Ignoring the output list:

// ```
// O(n)
// ```

// Including all generated subsets:

// ```
// O(n × 2ⁿ)
// ```
