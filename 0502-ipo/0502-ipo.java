class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
  int n = profits.length;
        int[][] projects = new int[n][2];

        // Combine profits and capital into a single array for easy sorting
        for (int i = 0; i < n; i++) {
            projects[i][0] = profits[i];
            projects[i][1] = capital[i];
        }

        // Sort projects by their capital requirements
        Arrays.sort(projects, (a, b) -> Integer.compare(a[1], b[1]));

        // Max-heap to store the profits of projects we can undertake
        PriorityQueue<Integer> maxProfitHeap = new PriorityQueue<>((a, b) -> Integer.compare(b, a));

        int current = 0;
        for (int i = 0; i < k; i++) {
            // Add all projects that can be started with the current capital to the max-heap
            while (current < n && projects[current][1] <= w) {
                maxProfitHeap.add(projects[current][0]);
                current++;
            }

            // If no projects can be started, break out of the loop
            if (maxProfitHeap.isEmpty()) {
                break;
            }

            // Start the project with the maximum profit
            w += maxProfitHeap.poll();
        }

        return w;
    }
}