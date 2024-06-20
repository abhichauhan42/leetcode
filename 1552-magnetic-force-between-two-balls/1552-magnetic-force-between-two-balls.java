class Solution {
    public int maxDistance(int[] position, int m) {
           Arrays.sort(position);
        int left = 1;  // minimum possible distance
        int right = position[position.length - 1] - position[0];  // maximum possible distance
        
        while (left < right) {
            int mid = (left + right + 1) / 2;  // candidate distance
            if (canPlaceBalls(position, m, mid)) {
                left = mid;  // try for a larger distance
            } else {
                right = mid - 1;  // try for a smaller distance
            }
        }
        
        return left;
    }
    
    private boolean canPlaceBalls(int[] position, int m, int minDist) {
        int count = 1;  // place the first ball
        int lastPosition = position[0];
        
        for (int i = 1; i < position.length; i++) {
            if (position[i] - lastPosition >= minDist) {
                count++;
                lastPosition = position[i];
                if (count == m) {
                    return true;
                }
            }
        }
        
        return false;
    }
}