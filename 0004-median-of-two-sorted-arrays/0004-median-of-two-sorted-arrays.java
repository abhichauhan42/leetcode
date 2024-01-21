class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m=nums1.length;
        int n=nums2.length;
        
        int temp[]=new int[m+n];
        int i=0;
        int e1=m;
        int j=0;
        int e2=n;
        int k=0;
        while(i<e1 && j<e2){
            if(nums1[i]<nums2[j]){
                temp[k]=nums1[i];
                k++;
                i++;
            }
            else{
                temp[k]=nums2[j];
                k++;
                j++;
            }
        }
        
        //for remaining
        while(i<e1){
            temp[k++]=nums1[i++];
        }
        
        while(j<e2){
            temp[k++]=nums2[j++];
        }
        
           double median;
        if ((m + n) % 2 == 0) {
            // Array has even length
            int mid1 = temp[(m + n) / 2 - 1];
            int mid2 = temp[(m + n) / 2];
            median = (double) (mid1 + mid2) / 2;
        } else {
            // Array has odd length
            median = temp[(m + n) / 2];
        }

        return median;
        
    }
}