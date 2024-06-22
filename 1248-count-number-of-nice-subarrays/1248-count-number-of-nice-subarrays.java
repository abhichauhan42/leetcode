class Solution {
   public int numberOfSubarrays(int[] nums, int k) {
        return atMostK(nums, k) - atMostK(nums, k - 1);
    }

    // Helper function to calculate the number of subarrays with at most K odd numbers
    private int atMostK(int[] nums, int k) {
        int start = 0;
        int oddCount = 0;
        int result = 0;

        for (int end = 0; end < nums.length; end++) {
            // Increment oddCount if current number is odd
            if (nums[end] % 2 != 0) {
                oddCount++;
            }

            // If there are more than k odd numbers, move the start pointer
            while (oddCount > k) {
                if (nums[start] % 2 != 0) {
                    oddCount--;
                }
                start++;
            }

            // All subarrays between start and end are valid
            result += end - start + 1;
        }

        return result;
    }
}