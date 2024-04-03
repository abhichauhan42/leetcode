class Solution {
    public int largestAltitude(int[] gain) {
        int maxAltitude = 0;
        int currentAltitude = 0;

        for (int altitudeGain : gain) {
            currentAltitude += altitudeGain;
            maxAltitude = Math.max(maxAltitude, currentAltitude);
        }

        return maxAltitude;
    }
}