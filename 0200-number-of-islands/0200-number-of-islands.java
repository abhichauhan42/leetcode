class Solution {
    
    public void dfs(char[][] grid,int i,int j){
        int m=grid.length;
        int n=grid[0].length;
        
        if(i<0 || i>=m ||j<0 || j>=n || grid[i][j]!='1'){
            return;
        }
        
        if(grid[i][j]==-1){
            return;
        }
        
        grid[i][j]='$'; //marked the element visited
        dfs(grid,i+1,j);
        dfs(grid,i-1,j);
        dfs(grid,i,j+1);
        dfs(grid,i,j-1);
    }
    public int numIslands(char[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
    int islands=0;
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]=='1'){
                    dfs(grid,i,j);
                    islands++;
                }
            }
        }
        return islands;
    }
}