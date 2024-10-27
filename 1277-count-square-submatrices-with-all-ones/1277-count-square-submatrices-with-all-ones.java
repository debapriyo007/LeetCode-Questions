class Solution {
    public int countSquares(int[][] matrix) {
        
        int row = matrix.length;
        int col = matrix[0].length;
        
        for(int i = 1;i<row;i++){
            for(int j = 1;j<col;j++){
                if(matrix[i][j] == 1){
                    matrix[i][j]+= Math.min(matrix[i-1][j] , Math.min(matrix[i-1][j-1], matrix[i][j-1]));
                }
            }
        }
        
        int totalSqr = 0;
        for(int[]ele : matrix){
            for(int x : ele){
                totalSqr += x;
            }
        }
        return totalSqr;
    }
}