class Solution {
    public int islandPerimeter(int[][] grid) {
          int perimeter = 0;
        
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    perimeter += 4; // Add 4 for each land cell
                    
                    // Check neighboring cells
                    if (i > 0 && grid[i - 1][j] == 1) // Top
                        perimeter -= 2; // Deduct 2 for each shared edge
                    if (j > 0 && grid[i][j - 1] == 1) // Left
                        perimeter -= 2; // Deduct 2 for each shared edge
                }
            }
        }
        
        return perimeter;
    }
}