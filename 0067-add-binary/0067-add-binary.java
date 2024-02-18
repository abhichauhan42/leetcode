class Solution {
    public String addBinary(String a, String b) {
        StringBuilder result = new StringBuilder();
        int carry = 0;
        
        // Start from the rightmost bits and move towards the left
        int i = a.length() - 1, j = b.length() - 1;
        
        // Iterate until both binary strings are processed
        while (i >= 0 || j >= 0 || carry != 0) {
            // Extract the current bits from both strings or use 0 if exhausted
            int bitA = (i >= 0) ? Character.getNumericValue(a.charAt(i)) : 0;
            int bitB = (j >= 0) ? Character.getNumericValue(b.charAt(j)) : 0;
            
            // Calculate the sum of bits and carry
            int currentSum = bitA + bitB + carry;
            
            // Append the result (0 or 1) to the left of the result string
            result.insert(0, currentSum % 2);
            
            // Update the carry for the next iteration
            carry = currentSum / 2;
            
            // Move to the next bit towards the left
            i--;
            j--;
        }
        
        return result.toString();

    }
}