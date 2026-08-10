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