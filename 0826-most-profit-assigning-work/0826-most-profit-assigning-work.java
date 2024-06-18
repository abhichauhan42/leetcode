class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
           int n = difficulty.length;
        int[][] jobs = new int[n][2];

        // Pairing difficulties with profits and sorting them by difficulty
        for (int i = 0; i < n; i++) {
            jobs[i][0] = difficulty[i];
            jobs[i][1] = profit[i];
        }
        Arrays.sort(jobs, (a, b) -> a[0] - b[0]);
        
        // Sorting workers by their ability
        Arrays.sort(worker);
        
        int maxProfit = 0, best = 0, i = 0;
        // Iterate through each worker
        for (int ability : worker) {
            // For each worker, find the best job they can perform
            while (i < n && ability >= jobs[i][0]) {
                best = Math.max(best, jobs[i][1]);
                i++;
            }
            // Accumulate the best profit this worker can achieve
            maxProfit += best;
        }
        
        return maxProfit;
    }
}