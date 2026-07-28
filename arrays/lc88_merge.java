public class lc88_merge {
    
}
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[]res=new int[m+n];
        for(int i=0;i<m;i++){
            res[i]=nums1[i];
        }
         for(int i=0;i<n;i++){
            res[m+i]=nums2[i];
        }
        Arrays.sort(res);
       for(int i=0;i<m+n;i++){
        nums1[i]=res[i];
       }

        
    }
}

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;

        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[k] = nums1[i];
                i--;
            } else {
                nums1[k] = nums2[j];
                j--;
            }
            k--;
        }

        while (j >= 0) {
            nums1[k] = nums2[j];
            j--;
            k--;
        }
    }
}