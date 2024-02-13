//{ Driver Code Starts
import java.util.*;

class MaxLenZeroSumSub
{

    // Returns length of the maximum length subarray with 0 sum

    // Drive method
    public static void main(String arg[])
    {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T > 0)
        {
            int n = sc.nextInt();
            int arr[] = new int[n];
            for (int i = 0; i < n; i++)
                arr[i] = sc.nextInt();

            GfG g = new GfG();
            System.out.println(g.maxLen(arr, n));
            T--;
        }
    }
}
// } Driver Code Ends


class GfG
{
    int maxLen(int arr[], int n)
    {
        // Your code here
        HashMap<Integer, Integer> map = new HashMap<>();
        
        //:Declear two varriable.
        int len = 0;
        int sum = 0;
        for(int i = 0;i<arr.length;i++){
            //have to calculate the sum here
            sum +=arr[i];
            //check if my summ is equal to 0
            // have to claculte the len.
            if(sum == 0){
                len = i+1;
            }
            
            //check my sum is in the map or not ?
            // if in the map
            if(map.containsKey(sum)){
                // have to do something
                // cal the len here.
                len = Math.max(len, i - map.get(sum)); //i - sum index value
            }else{
                //if sum is not in the map then i put it to the map with sum and index of i.
                map.put(sum , i);
            }
        }
        return len;
        
    }
}