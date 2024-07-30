class Solution {
    public int uniquePaths(int m, int n) {
         // return countPath(0, 0, m, n);
        return dpApproach(m, n, new int[m][n]);
    }
    
    
    //Dp approach..
    int dpApproach(int m, int n, int[][]dp){
        for(int i = 0;i< m;i++){
            for(int j = 0;j<n;j++){
                if(i == 0 || j == 0){
                    dp[i][j] = 1;
                }else{
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                }
            }
        }
        return dp[m-1][n-1];
    }
    
    //Using recursive approach.
   
    int countPath(int i, int j, int m, int n){
        //when i will reach my goal i return 1 coz, i find a unique path.
        if(i == (m-1) && j == (n-1))return 1;
        
        // i return 0 when i will out from the boundary of matrix.
        if(i >= m || j >= n)return 0;
        
        //for the downward.
        // int downWay = countPath(i+1, j, m, n);
        // int rightWay = countPath(i, j+1, m, n);
        return countPath(i+1, j, m, n) + countPath(i, j+1, m, n);
    }
}