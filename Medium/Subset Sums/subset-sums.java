//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0)
        {
            int N=sc.nextInt();
			ArrayList<Integer> arr = new ArrayList<>();
			for(int i = 0; i < N ; i++){
			    arr.add(sc.nextInt());
			}
            Solution ob = new Solution();
         
            ArrayList<Integer> ans = ob.subsetSums(arr,N);
            Collections.sort(ans);
            for(int sum : ans){
                System.out.print(sum+" ");
            }
            System.out.println();
        }  
    }
}

// } Driver Code Ends


//User function Template for Java//User function Template for Java
class Solution{
    ArrayList<Integer> subsetSums(ArrayList<Integer> arr, int N){
        ArrayList<Integer> ans =  new ArrayList<>();
        findSubSetSum(0, 0, arr, N,ans);
        return ans;
       
    }
    
    public static void findSubSetSum(int index, int sum ,  ArrayList<Integer> arr,int N, ArrayList<Integer>list){
        
        if(index == N){
            list.add(sum);
            return;
        }
        //Pick condition.
        findSubSetSum(index+1, sum + arr.get(index),arr, N, list);
        //Non Pick Condition.
        findSubSetSum(index+1, sum , arr, N, list);
    }
}