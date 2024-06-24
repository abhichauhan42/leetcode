class Solution {
   public int numberOfSubarrays(int[] nums, int k) {
        return atMostK(nums, k) - atMostK(nums, k - 1);
    }

    // Helper function to calculate the number of subarrays with at most K odd numbers
    private int atMostK(int[] nums, int k) {
        int start = 0, end = 0;
        int oddCount = 0, result = 0;

        while (end < nums.length) {
            if (nums[end] % 2 != 0) {
                oddCount++;
            }
            
            while (oddCount > k) {
                if (nums[start] % 2 != 0) {
                    oddCount--;
                }
                start++;
            }
            
            result += end - start + 1;
            end++;
        }

        return result;
    }
}