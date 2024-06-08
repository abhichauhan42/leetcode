class Solution {
    public int subarraySum(int[] nums, int k) {
            int n = nums.length;
        if (n == 0) {
            return 0;
        }
        
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);  // Initialize to handle subarray starting from index 0.
        
        int sum = 0;
        int count = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            
            // Check if there is a prefix sum that when subtracted from current sum equals to k
            if (map.containsKey(sum - k)) {
                count += map.get(sum - k);
            }
            
            // Add the current sum to the map
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        
        return count;
    }
}