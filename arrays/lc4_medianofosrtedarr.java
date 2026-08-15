class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n=nums1.length;
        int m=nums2.length;
        int[]arr=new int[n+m];
        int j=0;
        for(int i=0;i<n;i++){
            arr[j++]=nums1[i];
        }
        for(int i=0;i<m;i++){
            arr[j++]=nums2[i];
        }
        Arrays.sort(arr);
        int k=arr.length;
        double ans=0;
        int mid=k/2;
        if(k%2==1){
            
            ans=arr[mid];          
        }else{
            ans=(arr[mid-1]+arr[mid])/2.0;
        }
        return ans;
    }
}
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;

        int[] arr = new int[n + m];

        int i = 0, j = 0, k = 0;

        while (i < n && j < m) {
            if (nums1[i] < nums2[j]) {
                arr[k++] = nums1[i++];
            } else {
                arr[k++] = nums2[j++];
            }
        }

        while (i < n) {
            arr[k++] = nums1[i++];
        }

        while (j < m) {
            arr[k++] = nums2[j++];
        }

        int len = n + m;
        int mid = len / 2;

        if (len % 2 == 1) {
            return arr[mid];
        }

        return (arr[mid - 1] + arr[mid]) / 2.0;
    }
}