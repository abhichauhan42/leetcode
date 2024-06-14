class Solution {
    public int minIncrementForUnique(int[] nums) {
         // Sort the array
        Arrays.sort(nums);
        
        int moves = 0;
        // Start from the second element and compare it with the previous one
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] <= nums[i - 1]) {
                // Calculate the required increment to make nums[i] unique
                int increment = nums[i - 1] - nums[i] + 1;
                // Add the increment to nums[i]
                nums[i] += increment;
                // Add the increment to the move counter
                moves += increment;
            }
        }
        return moves;
    }
}