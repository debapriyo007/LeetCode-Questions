//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class GFG {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int t=sc.nextInt();
		
		while(t-->0)
		{
		    int n=sc.nextInt();
		    int a[]=new int[n];
		    
		    for(int i=0;i<n;i++)
		    {
		        a[i]=sc.nextInt();
		    }
		    int m=sc.nextInt();
		    Solution ob = new Solution();
		    System.out.println(ob.findPages(a,n,m));
		}
	}
}
// } Driver Code Ends


//User function Template for Java

class Solution 
{
    public static int CountSt(int arr[], int pages){
        int st = 1;
        int  pagesSt = 0;
        for(int i = 0;i<arr.length;i++){
            if(pagesSt + arr[i] <= pages){
               pagesSt+= arr[i]; 
            }else{
                st++;
                pagesSt = arr[i];
            }
        }
        return st;
    }
    
    //Function to find minimum number of pages.
    public static int findPages(int[]A,int N,int M)
    {
        //Your code here
        if(M>N)return -1;
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for( int i = 0;i<N;i++){
            sum += A[i];
            max = Math.max(A[i], max);
        }
        
        int low = max;
        int high = sum;
        while(low<=high){
            int mid = (low+high)/2;
            int students = CountSt(A, mid);
            if(students>M){
                low = mid+1;
            }else{
                high = mid-1;
            }
        }
        return low;
    }
};