//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
class Rat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int[][] a = new int[n][n];
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++) a[i][j] = sc.nextInt();

            Solution obj = new Solution();
            ArrayList<String> res = obj.findPath(a, n);
            Collections.sort(res);
            if (res.size() > 0) {
                for (int i = 0; i < res.size(); i++)
                    System.out.print(res.get(i) + " ");
                System.out.println();
            } else {
                System.out.println(-1);
            }
        }
    }
}

// } Driver Code Ends


// User function Template for Java

// m is the given matrix and n is the order of matrix
class Solution {
    public static ArrayList<String> findPath(int[][] m, int n) {
        
     ArrayList<String> ans = new ArrayList<>();
     
     //create a 2D matrix which will track my all moves.
     int visit[][] = new int[n][n];
     if (m[0][0] == 1) solve(0, 0, m, n, ans, "", visit);
     return ans;
        
    }
    
    
    public static void solve(int i , int j, int arr[][], int n ,  ArrayList<String> ans, String move, int visit [][]){
        
        //Base Case.
        if(i ==n-1 && j == n-1){ // i and j ref as Row, Col
            ans.add(move);
            return;
        }
        
        //Downward.
        if(i+1 < n && visit[i+1][j] == 0 && arr[i+1][j] == 1){
            visit[i][j] =1;
            solve(i+1, j, arr, n , ans, move+'D' , visit);
            visit[i][j] = 0;
        }
        
        //Left
        if(j-1>= 0 && visit[i][j-1] == 0  && arr[i][j-1] == 1){
            visit[i][j] =1;
            solve(i, j-1, arr, n , ans, move+'L' , visit);
            visit[i][j] = 0;
        }
        
         // right 
        if (j + 1 < n && visit[i][j + 1] == 0 && arr[i][j + 1] == 1) {
            visit[i][j] = 1;
            solve(i, j + 1, arr, n, ans, move +'R', visit);
            visit[i][j] = 0;
        }
        
        // upward
        if (i - 1 >= 0 && visit[i - 1][j] == 0 && arr[i - 1][j] == 1) {
            visit[i][j] = 1;
            solve(i - 1, j, arr, n, ans, move + 'U', visit);
            visit[i][j] = 0;
        }
    }
}