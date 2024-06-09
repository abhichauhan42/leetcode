class Solution {
    public int minSubarray(int[] nums, int p) {
          int n = nums.length;
        long totalSum = 0;
        
        // Calculate total sum of the array
        for (int num : nums) {
            totalSum += num;
        }
        
        // Find the remainder when total sum is divided by p
        long remainder = totalSum % p;
        
        // If the remainder is 0, the array is already divisible by p
        if (remainder == 0) {
            return 0;
        }
        
        // HashMap to store prefix sum mod p and its index
        HashMap<Long, Integer> prefixMap = new HashMap<>();
        prefixMap.put(0L, -1); // To handle the case when the prefix sum itself is the answer
        
        long prefixSum = 0;
        int minLen = n;
        
        // Iterate through the array to find the smallest subarray to remove
        for (int i = 0; i < n; i++) {
            prefixSum += nums[i];
            long currentMod = prefixSum % p;
            long targetMod = (currentMod - remainder + p) % p;
            
            if (prefixMap.containsKey(targetMod)) {
                minLen = Math.min(minLen, i - prefixMap.get(targetMod));
            }
            
            prefixMap.put(currentMod, i);
        }
        
        // If minLen is still n, it means no valid subarray was found
        return minLen == n ? -1 : minLen;
    }
}