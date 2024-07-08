class Solution {
    public int findTheWinner(int n, int k) {
         int winner = 0; // The Josephus position for 1 person is 0
        for (int i = 2; i <= n; i++) {
            winner = (winner + k) % i;
        }
        return winner + 1; // Adjusting to 1-based index
    }
}