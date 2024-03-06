//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main(String[] args) throws IOException
	{
	        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t =
            Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while(t-->0)
        {
            long n = Long.parseLong(br.readLine().trim());
            long a[] = new long[(int)(n)];
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Long.parseLong(inputLine[i]);
            }
            
            Compute obj = new Compute();
            long[] product = obj.minAnd2ndMin(a, n); 
            if(product[0]==-1)
                System.out.println(product[0]);
            else
                System.out.println(product[0]+" "+product[1]);
            
        }
	}
}


// } Driver Code Ends


//User function Template for Java


class Compute 
{


    public static long smallestEl(long arr[], long n){
        long small = arr[0];
        for(int i = 0;i<arr.length;i++){
            if(arr[i]<small){
                small = arr[i];
            }
        }
        return small;
    }
    
    public long[] minAnd2ndMin(long a[], long n)  
    {
        
            long res[] = new long[2];
            long smallestElement = smallestEl(a,n);
            long sndSmallest = Long.MAX_VALUE;
 
            for(int i = 0;i<n;i++){
                if(a[i]<sndSmallest && a[i]!= smallestElement){
                    sndSmallest = a[i];
                }
            }
            if(smallestElement == Long.MAX_VALUE || sndSmallest == Long.MAX_VALUE ){
                return new long[]{-1,-1};
            }
            res[0] = smallestElement;
            res[1] = sndSmallest;
            return res;
    }
}
