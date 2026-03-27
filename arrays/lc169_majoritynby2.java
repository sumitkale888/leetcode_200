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