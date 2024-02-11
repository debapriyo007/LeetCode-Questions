/*
Time Complexity :- O(9(n ^ 2)), in the worst case, for each cell in the n2 board, we have 9 possible numbers.

Space Complexity :- O(1)

*/

class Solution {
    public void solveSudoku(char[][] board) {
        solve(board);
    }
    
    //create a methord that slove .
    public static boolean solve(char[][] board){
        //first check where is empty box in my 9 x 9 Grid.
        for(int i = 0;i<board.length;i++){
            for(int j = 0;j<board[0].length;j++){
                //check empty place.
                if(board[i][j] == '.'){
                    //now i check form (1-9) , can i put that or not ?
                    for(char c = '1';c<='9';c++){
                        // if i put from ('1 -9 ') is that valid or not?
                        if(isValid(board, i, j, c)){
                            //put that as it is.
                            board[i][j] = c;
                            
                            //and recursivly call form the bellow board.
                            if(solve(board) == true)
                                return true;
                            else
                                board[i][j] = '.';
                        }
                    }
                    return false; // when i can't put any character like (1-9)
                }
            }
        }
        //when i get my suduko slove return "true"
        return true;
        
    }
    
    
    //keep the all condition in mind check that can i put (1-9)
    //means is it valid to put 
    public static boolean isValid(char board[][], int row, int col, char c){
        for(int i = 0;i<9;i++){
            if(board[i][col] == c)
                return false;
            if(board[row][i] == c)
                return false;
            
            //chcek for 3 x 3 grid.
            if(board[3*(row/3)+i/3][3*(col/3)+i%3] == c) // Doubt!!!!
                return false;
        }
        return true;
    }
}


