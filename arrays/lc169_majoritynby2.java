class Solution {
    public int majorityElement(int[] nums) {
        int count = 0;
        int el = 0;
        for (int i = 0; i < nums.length; i++) {
            if (count == 0) {
                count = 1;
                el = nums[i];
            } else if (nums[i] == el) {
                count++;
            } else {
                count--;
            }
        }
        int cnt = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == el) {
                cnt++;
            }
        }
        if (cnt > nums.length / 2) {
            return el;
        }
        return -1;
    }
}

//another simple way

      class Solution {
    public int majorityElement(int[] nums) {
        int count = 0;
        int candidate = 0;

        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }

            if (num == candidate) {
                count++;
            } else {
                count--;
            }
        }

        return candidate;
    }
}
// if(num==candidate) count++;
// else if(count==0) candidate=num;
// else count--;
// Step 1: Candidate Selection

// We keep:

// el → current candidate

// count → vote count

// Rules:

// 1️⃣ If count == 0
// → choose current number as new candidate

// 2️⃣ If number == candidate
// → increase vote

// 3️⃣ If number ≠ candidate
// → decrease vote (cancel one vote)

// This works because majority element cannot be completely canceled.
// Idea: Majority element appears more than n/2 times, so it will survive all cancellations.
[2, 2, 1, 1, 1, 2, 2]
num    candidate	count
2	    2	         1
2	    2	         2
1	    2	         1
1	    2	         0
1	    1	         1
2	    1	         0
2	    2	         1

Final answer = 2

In general:

If two different elements meet, they cancel each other.
Since the majority element appears more than n/2 times, there are not enough other elements to completely cancel it.
Therefore, after all possible cancellations, the majority element is the only one that can survive.