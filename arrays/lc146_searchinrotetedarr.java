class Solution {
    public int search(int[] nums, int target) {
        int s=0;
        int e=nums.length-1;
        while(s<=e){
            int mid=s+(e-s)/2;


            if(nums[mid]==target)return mid;

            if(nums[mid]>=nums[s]){
                if(nums[mid]>=target&&target>=nums[s]){
                    e=mid-1;
                }else{
                    s=mid+1;
                }
            }else{
                if(target>=nums[mid]&&target<=nums[e]){
                    s=mid+1;
                }else{
                    e=mid-1;
                }
            }

        }
        return -1;
    }
}


//                  Find mid
//                     ↓
//           Is left half sorted?
//              /             \
//            YES              NO
//             ↓                ↓
//    Is target in left?   Is target in right?
//        /      \             /      \
//      YES      NO          YES      NO
//       ↓        ↓            ↓        ↓
//    go left  go right     go right  go left