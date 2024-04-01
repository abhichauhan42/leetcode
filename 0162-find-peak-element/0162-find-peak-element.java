class Solution {
    public int findPeakElement(int[] nums) {
        int indx=0;
        for(int i=1;i<nums.length;i++){
            if(nums[indx]<nums[i]){
                indx=i;
            }
        }
        return indx;
    }
}