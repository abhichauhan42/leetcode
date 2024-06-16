class Solution {
    public int minPatches(int[] nums, int n) {
         long miss = 1; // the smallest number that cannot be formed
        int patches = 0, i = 0;

        while (miss <= n) {
            if (i < nums.length && nums[i] <= miss) {
                // If the current number in the array is less than or equal to 'miss',
                // it can be used to form 'miss', so we add its value to 'miss'
                miss += nums[i];
                i++;
            } else {
                // If the current number in the array is greater than 'miss',
                // we need to add 'miss' itself to the array (patching it)
                miss += miss;
                patches++;
            }
        }

        return patches;
    }
}