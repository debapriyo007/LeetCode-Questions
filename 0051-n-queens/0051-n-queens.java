class Solution {
    public List<List<String>> solveNQueens(int n) {
        
        //first ceating a board and initilize with all box as '.'
        char [][] board = new char[n][n];
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board.length; j++) {
                board[i][j] = '.';
            }
        }
        
        // as per return type create a ans list of list.
        List<List<String>> ans = new ArrayList<>();
        queen(board, 0, ans);
        return ans;
    }


    static boolean isSafe(char[][] board, int row, int col) {

        //for checking vertical row ("Lomba Lombi")
        for (int i = 0; i < row; i++) {
            if(board[i][col] == 'Q') {
                return false;
            }
        }

        //for checking left diagonal("Bamdiker Kona Koni.")

        int maxLeft = Math.min(row, col);

        for (int i = 1; i <= maxLeft; i++) {
            if(board[row - i][col - i] == 'Q') {
                return false;
            }
        }

        //for checking right diagonal ("Dandiker Kona Koni.")

        int maxRight = Math.min(row, board.length - 1 - col);

        for (int i = 1; i <= maxRight; i++) {
            if(board[row - i][col + i] == 'Q') {
                return false;
            }
        }

        return true;
    }

   //This is the innerList.
   static List<String> construct(char[][] board) {
        List<String> innerList = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            String row = new String(board[i]);
            innerList.add(row);
        }
        return innerList;
    }

    //The main Methord
    static void queen(char[][] board, int row, List<List<String>> list) {

        if(row == board.length) {

            list.add(construct(board));
            return;
        }

        for (int col = 0; col < board.length; col++) {
            if(isSafe(board, row, col)) {
                board[row][col] = 'Q';
                queen(board, row + 1, list);
                board[row][col] = '.';
            }
        }
    }
}