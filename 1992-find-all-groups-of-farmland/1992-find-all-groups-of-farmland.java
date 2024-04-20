class Solution {
    public int[][] findFarmland(int[][] land) {
         List<int[]> result = new ArrayList<>();
        
        int m = land.length;
        int n = land[0].length;
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (land[i][j] == 1) {
                    int rowEnd = i, colEnd = j;
                    while (rowEnd + 1 < m && land[rowEnd + 1][j] == 1) {
                        rowEnd++;
                    }
                    while (colEnd + 1 < n && land[i][colEnd + 1] == 1) {
                        colEnd++;
                    }
                    result.add(new int[]{i, j, rowEnd, colEnd});
                    // Mark visited land as 0 to avoid re-processing
                    for (int row = i; row <= rowEnd; row++) {
                        for (int col = j; col <= colEnd; col++) {
                            land[row][col] = 0;
                        }
                    }
                }
            }
        }
        
        int[][] output = new int[result.size()][4];
        for (int i = 0; i < result.size(); i++) {
            output[i] = result.get(i);
        }
        
        return output;
    }
}