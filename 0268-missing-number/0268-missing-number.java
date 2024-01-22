import java.util.Arrays;

class Solution {
    public int missingNumber(int[] nums) {
        Arrays.sort(nums);

        // Check for missing number at the beginning
        if (nums[0] != 0) {
            return 0;
        }

        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i + 1] - nums[i] > 1) {
                return nums[i] + 1;
            }
        }

        // Check for missing number at the end
        return nums[nums.length - 1] + 1;
    }
}
