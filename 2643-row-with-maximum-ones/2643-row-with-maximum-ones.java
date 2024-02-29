class Solution {
    
    //Time Complexity - > 0(N^2)
    //Space Complexity -> 0(1)
    
    public int[] rowAndMaximumOnes(int[][] mat) {
        int res[] = new int[2];
        
        int max = Integer.MIN_VALUE;
        for(int i = 0;i<mat.length;i++){
            int cnt_ones  = 0;
            for(int j = 0;j<mat[0].length;j++){
                if(mat[i][j] == 1){
                    cnt_ones++;
                }
            }
            if(cnt_ones>max){
                max  = cnt_ones;
                res[0] = i;
                res[1]= max;
            }
        }
        return res;
    }
}