class Solution {
    public int minKBitFlips(int[] nums, int k) {
        int n = nums.length;
    int flipCount = 0;
    int[] flipArray = new int[n]; // to keep track of where flips happen
    int prefixFlipCount = 0; // current number of flips applied so far
    
    for (int i = 0; i < n; i++) {
        if (i >= k) {
            // Adjust prefixFlipCount when moving window and flipping out of the window
            prefixFlipCount -= flipArray[i - k];
        }
        
        // Check if nums[i] needs to be flipped
        if ((nums[i] + prefixFlipCount) % 2 == 0) {
            if (i + k > n) {
                // If there are not enough elements left to flip, return -1
                return -1;
            }
            // Flip is needed at position i
            flipCount++;
            flipArray[i] = 1; // mark a flip at position i
            prefixFlipCount++; // increase the flip count in the current window
        }
    }
    
    return flipCount;
    }
}