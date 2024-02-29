class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        
        int n = matrix.length;
        int m = matrix[0].length;
        
        int si = 0;
        int ei = m*n-1;
        while(si<=ei){
            int mid = (si+ei)/2;
            int elem_looking_for = matrix[mid/m][mid%m];
            if(elem_looking_for == target){
                return true;
            }else if(elem_looking_for<target){
                si = mid+1;
            }else{
                ei = mid-1;
            }
        }
        return false;
    }
}