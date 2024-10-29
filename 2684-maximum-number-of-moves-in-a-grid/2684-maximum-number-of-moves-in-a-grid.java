class Pair{
    int row;
    int col;
    int x; //vari to make cnt.
    
    Pair(int row, int col, int x){
        this.row = row;
        this.col = col;
        this.x = x;
    }
}


class Solution {
    public int maxMoves(int[][] grid) {
        
        int n = grid.length;
        int m = grid[0].length;
        
        Queue<Pair> q = new LinkedList<>();
        boolean[][]vis = new boolean[n][m];
        
        for(int i = 0;i<n;i++){
            if(!vis[i][0]){
                q.add(new Pair(i, 0, 0));
                vis[i][0] = true;
            }
        }
        
        int maxCnt = Integer.MIN_VALUE;
        while(!q.isEmpty()){
            Pair pair = q.poll();
            int x = pair.row;
            int y = pair.col;
            int cnt = pair.x;
            
            int[] x_axis={-1,0,1};
            int[] y_axis={1,1,1};
            
            for(int k = 0;k<3;k++){
                int move_x = x + x_axis[k];
                int move_y = y + y_axis[k];
                
                if(move_x >= 0 && move_x < n && move_y >= 0 && move_y < m &&
                  vis[move_x][move_y] == false && grid[x][y] < grid[move_x][move_y]){
                    q.add(new Pair(move_x , move_y, cnt+1));
                    vis[move_x][move_y] = true;
                }
            }
            maxCnt = Math.max(maxCnt, cnt);
        }
        return maxCnt;
    }
}