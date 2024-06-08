class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
          int n = nums.length;
        if (n == 0) {
            return false;
        }
        
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);  // Initialize with 0 mod value to handle subarray starting from index 0.
        
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            int mod = sum % k;
            // Adjust negative mod values to be positive
            if (mod < 0) {
                mod += k;
            }
            if (map.containsKey(mod)) {
                if (i - map.get(mod) > 1) {  // Ensure the subarray length is at least 2
                    return true;
                }
            } else {
                map.put(mod, i);
            }
        }
        
        return false;
    }
}
