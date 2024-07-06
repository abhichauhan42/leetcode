class Solution {
    public int passThePillow(int n, int time) {
         // Calculate the total cycle length
        int cycleLength = 2 * (n - 1);
        
        // Find the effective time in the current cycle
        int effectiveTime = time % cycleLength;
        
        // Determine the position based on effective time
        if (effectiveTime <= n - 1) {
            // Moving forward in the line
            return effectiveTime + 1;
        } else {
            // Moving backward in the line
            return 2 * n - 1 - effectiveTime;
        }
    }
}