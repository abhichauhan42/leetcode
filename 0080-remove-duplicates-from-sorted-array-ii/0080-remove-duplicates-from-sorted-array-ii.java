class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        int count = 0;

        for (int i = 0; i < n; i++) {
            int current = nums[i];
            int j = i + 1;

            while (j < n && nums[j] == current) {
                j++;
            }

            int occurrences = j - i;
            int minOccurrences = Math.min(occurrences, 2);

            for (int k = 0; k < minOccurrences; k++) {
                nums[count++] = current;
            }

            i = j - 1;
        }

        return count;
    }
}
