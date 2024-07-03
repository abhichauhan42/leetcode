class Solution {
    public int minDifference(int[] nums) {
          int n = nums.length;
        if (n <= 4) return 0; // If there are 4 or fewer elements, we can make all elements the same

        Arrays.sort(nums);
        
        // Possible scenarios:
        // 1. Change the largest 3 elements
        // 2. Change the largest 2 elements and the smallest 1 element
        // 3. Change the largest 1 element and the smallest 2 elements
        // 4. Change the smallest 3 elements
        int result = Integer.MAX_VALUE;
        
        // Check the difference between the appropriate min and max for each scenario
        result = Math.min(result, nums[n-4] - nums[0]);
        result = Math.min(result, nums[n-3] - nums[1]);
        result = Math.min(result, nums[n-2] - nums[2]);
        result = Math.min(result, nums[n-1] - nums[3]);
        
        return result;
    }
}