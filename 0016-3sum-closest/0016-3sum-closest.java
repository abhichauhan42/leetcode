class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int closestSum = nums[0] + nums[1] + nums[2];

        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (Math.abs(sum - target) <= Math.abs(closestSum - target)) {
                    closestSum = sum;
                }

                if (sum > target) {
                    right--;
                } else if (sum < target) {
                    left++;
                } else {
                    // If sum == target, it's the closest possible sum
                    return sum;
                }
            }
        }
        return closestSum;
    }
}
