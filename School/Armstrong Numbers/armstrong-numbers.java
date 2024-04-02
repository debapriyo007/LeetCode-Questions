//{ Driver Code Starts
//Initial Template for Java
import java.util.*;
import java.io.*;
class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(read.readLine());
            Solution ob = new Solution();

            System.out.println(ob.armstrongNumber(n));
        }
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution {
    static String armstrongNumber(int n){
        // code here
        int originalNum = n;
        int AstSum = 0;
        while(n!=0){
            int lastDigit  = n%10;
            AstSum+= lastDigit*lastDigit*lastDigit;
            n = n/10;
        }
        if(originalNum == AstSum){
           return "Yes";
        }else{
           return "No"; 
        }
    }
}