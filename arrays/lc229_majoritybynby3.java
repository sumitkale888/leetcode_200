class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int c1=0,c2=0;
        int el1=0,el2=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==el1){
                c1++;
            }else if(nums[i]==el2){
               c2++;
            }else if(c1==0){
                el1=nums[i];
                c1=1;
            }else if(c2==0){
                el2=nums[i];
                c2=1;
                
            }else{
                c1--;
                c2--;
            }
        }
        int i=0;
        int j=0;
        for(int n:nums){
            if(n==el1)i++;
            else if(n==el2)j++;
        }
        List<Integer>res=new ArrayList<>();
        
        if(i>nums.length/3)res.add(el1);
        if(j>nums.length/3)res.add(el2);

        return res;
    
        
    }
    
}

// For Majority Element II

// Core Intuition

// If an element appears more than ⌊n/3⌋ times, there can be at most 2 such elements.

// Why?

// If there were 3 elements each appearing more than n/3:

// > n/3 + > n/3 + > n/3  > n

// which is impossible.

// So we only track 2 candidates.

// Idea of the Algorithm (Voting / Cancellation)

// Think of it like voting:

// Each number votes for itself.
// When we see a different number, votes cancel.
// Cases while iterating

// 1️⃣ Same as candidate1 → increase count1

// 2️⃣ Same as candidate2 → increase count2

// 3️⃣ count1 == 0 → new candidate1

// 4️⃣ count2 == 0 → new candidate2

// 5️⃣ Otherwise → cancel both votes

// count1--
// count2--

// This represents three different numbers cancelling each other.