class Solution {
    public void sortColors(int[] nums) {
      int mid=0;
      int low=0;
      int high=nums.length-1;

      while(mid<=high){
        if(nums[mid]==0){
            int temp=nums[mid];
            nums[mid]=nums[low];
            nums[low]=temp;
            mid++;
            low++;
        }else if(nums[mid]==1){
            mid++;
        }else{
            int temp=nums[mid];
            nums[mid]=nums[high];
            nums[high]=temp;
            high--;
        }
      }
        
    }
}
// This is the Dutch National Flag Algorithm (LeetCode 75: Sort Colors).

// Intuition

// The array contains only three values:

// 0 → should be on the left.
// 1 → should be in the middle.
// 2 → should be on the right.

// Instead of sorting the array, we place each element directly into its correct region using three pointers.

// Three Pointers
// low → next position where a 0 should go.
// mid → current element being examined.
// high → next position where a 2 should go.

// Initially:

// [ ?, ?, ?, ?, ?, ? ]
//   ↑
// low
//   ↑
// mid
//               ↑
//              high

// The array is divided into four parts:

// 0 ........ low-1     → All 0s
// low ...... mid-1     → All 1s
// mid ...... high      → Unknown elements
// high+1 ... end       → All 2s

// Why?

Because the element that came from high is unknown. It could be 0, 1, or 2, so it must be checked again.
Step	    Array	        low 	mid	    high
Start	    [2,0,2,1,1,0]	0	    0	    5
Swap 2↔0   	[0,0,2,1,1,2]	0	    0	    4
0 found	    [0,0,2,1,1,2]	1	    1	    4
0 found	    [0,0,2,1,1,2]	2	    2	    4
Swap 2↔1	[0,0,1,1,2,2]	2	    2	    3
1 found	    [0,0,1,1,2,2]	2	    3	    3
1 found	    [0,0,1,1,2,2]	2	    4	    3