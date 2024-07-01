class Solution {
    public boolean threeConsecutiveOdds(int[] arr) {
       int count = 0;
        
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 != 0) {  // Check if the number is odd
                count++;
                if (count == 3) {  // Check if we have found three consecutive odds
                    return true;
                }
            } else {
                count = 0;  // Reset the count if the number is even
            }
        }
        
        return false;  // Return false if no three consecutive odds are found
    }
}