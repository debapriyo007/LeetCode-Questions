//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t;
        t = sc.nextInt();
        while (t-- > 0) {

            int n;
            n = sc.nextInt();

            int k;
            k = sc.nextInt();

            int[] v = new int[n];
            for (int i = 0; i < n; i++) v[i] = sc.nextInt();

            Solution obj = new Solution();
            int res = obj.solve(n, k, v);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends


// User function Template for Java
class Solution {
    //This methord is for place the cows 
    public static boolean isPlace(int arr[], int dist, int cows){
        int n = arr.length;
        //place the first cow.
        //i place the first cow at 0th index.
          int fstCow = arr[0];
          int countCows = 1;
          
          //i will be check for i can place or not.
          for(int i = 0;i<n;i++){
              if(arr[i] - fstCow >= dist){
                  //means it possible.
                  countCows++;
                  fstCow = arr[i]; //  move my first cow.
                }
              
              if(countCows >= cows)return true;
            }
          return false;
    }
  
    public static int solve(int n, int k, int[] stalls) {
        //Step 1: Sort the cows.
        Arrays.sort(stalls);
        int low = 1;
        int high = stalls[n-1] - stalls[0];
        
        while(low<=high){
            int mid = (low+high)/2;
            if(isPlace(stalls, mid, k) == true){ //means place possible
            //i seach for maximum distance.
                low = mid+1;
            }else{
                high = mid-1;
            }
        }
        return high;
    }
}