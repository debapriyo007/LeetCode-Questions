class Solution {
    public List<Integer> luckyNumbers (int[][] matrix) {
        List<Integer>ans = new ArrayList<>();


        int row = matrix.length;
        int col = matrix[0].length;

        // find all row mini elements
        List<Integer>list1 = new ArrayList<>();
        for(int i = 0;i<row;i++){
            int min = Integer.MAX_VALUE;
            for(int j = 0;j<col;j++){
                min = Math.min(min,matrix[i][j]);

            }
            list1.add(min);
        }
        
        // find all col elements.
        List<Integer>list2 = new ArrayList<>();
        for(int i = 0;i<col;i++){
            int max = Integer.MIN_VALUE;
            for(int j = 0;j<row;j++){
                max = Math.max(max,matrix[j][i]);

            }
            list2.add(max);
        }

        //then iterate throght matrix check for that elem which overlap.
        for(int i = 0;i<row;i++){
            for(int j = 0;j<col;j++){
               if(list1.contains(matrix[i][j]) && list2.contains(matrix[i][j])){
                    ans.add(matrix[i][j]);
                }
            }
            
        }
        return ans;
    }
}