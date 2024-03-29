class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int totalTank = 0;
        int currentTank = 0;
        int startStation = 0;

        for (int i = 0; i < n; i++) {
            totalTank += gas[i] - cost[i];
            currentTank += gas[i] - cost[i];

            if (currentTank < 0) {
                startStation = i + 1;
                currentTank = 0;
            }
        }

        if (totalTank < 0) {
            return -1;
        } else {
            return startStation;
        }
    }
}
