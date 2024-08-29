class Solution {
    
    boolean dfs(int row, int col ,int[][] grid1, int[][] grid2, boolean[][]vist){
        
        vist[row][col] = true;
        boolean isIsland = true;
        if(grid1[row][col] == 0) isIsland = false;
        
        int n = grid1.length;
        int m = grid2[0].length;
        //now move 4 dir.
        int[]delRow = {-1, 0, +1, 0};
        int[]delCol = {0, -1, 0, +1};
        for(int i = 0;i<4;i++){
            int nRow = row + delRow[i];
            int nCol = col + delCol[i];
            if(nRow >= 0 && nCol >= 0 && nRow<n && nCol < m
              && grid2[nRow][nCol] == 1 && !vist[nRow][nCol]){
                boolean res =  dfs(nRow,nCol,grid1,grid2,vist);
                isIsland = isIsland && res;
            }
        }
        return isIsland;
    }
    
    
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        
        int row = grid1.length;
        int col = grid2[0].length;
        
        boolean[][]vist = new boolean[row][col];
        int cnt = 0;
        for(int i = 0 ;i<row;i++){
            for(int j = 0;j<col ;j++){
                if(!vist[i][j] && grid2[i][j] == 1){
                    if(dfs(i, j, grid1, grid2, vist)){
                        cnt++;
                    }
                }
            }
        }
        return cnt;
    }
}