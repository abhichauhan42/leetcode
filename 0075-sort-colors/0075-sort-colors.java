class Solution {
    public void sortColors(int[] nums) {
          int low = 0;
        int high = nums.length - 1;
 
        for (int i = 0; i < nums.length && i <= high;) {
            // Current element is 0
            if (nums[i] == 0) {
                swap(nums, low, i);
                low++;
                i++;
            }
            // Current element is 2
            else if (nums[i] == 2) {
                swap(nums, i, high);
                high--;
            }
            // Current element is 1
            else {
                i++;
            }
        }
    }
    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}