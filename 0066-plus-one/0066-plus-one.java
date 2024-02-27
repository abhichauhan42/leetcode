class Solution {
    public int[] plusOne(int[] digits) {
         
         int n = digits.length;
        
        // Increment the least significant digit by 1
        digits[n - 1]++;
        
        // Handle any carry
        for (int i = n - 1; i > 0 && digits[i] == 10; i--) {
            digits[i] = 0;
            digits[i - 1]++;
        }
        
        // If the most significant digit has a carry, create a new array with an extra digit
        if (digits[0] == 10) {
            int[] result = new int[n + 1];
            result[0] = 1;
            return result;
        }
        
        return digits;
    }
}