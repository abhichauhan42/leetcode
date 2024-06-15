class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
         PriorityQueue<int[]> minCapitalHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        
        // Create a max-heap for profits of projects that can be undertaken
        PriorityQueue<Integer> maxProfitHeap = new PriorityQueue<>(Comparator.reverseOrder());
        
        // Populate the min-heap with all projects
        for (int i = 0; i < profits.length; i++) {
            minCapitalHeap.offer(new int[]{profits[i], capital[i]});
        }
        
        // Try to undertake up to k projects
        for (int i = 0; i < k; i++) {
            // Move all projects that can be started with current capital to the max-profit heap
            while (!minCapitalHeap.isEmpty() && minCapitalHeap.peek()[1] <= w) {
                maxProfitHeap.offer(minCapitalHeap.poll()[0]);
            }
            
            // If there are no projects that can be started, break out of the loop
            if (maxProfitHeap.isEmpty()) {
                break;
            }
            
            // Start the project with the maximum profit
            w += maxProfitHeap.poll();
        }
        
        return w;
    }
}