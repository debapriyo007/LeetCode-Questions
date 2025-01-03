//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());

        while (tc-- > 0) {
            // String[] nk = br.readLine().trim().split(" ");
            // int n = Integer.parseInt(nk[0]);
            // int k = Integer.parseInt(nk[1]);

            String[] str = br.readLine().trim().split(" ");
            int[] a = new int[str.length];
            for (int i = 0; i < str.length; i++) {
                a[i] = Integer.parseInt(str[i]);
            }
            String[] nk = br.readLine().trim().split(" ");
            int k = Integer.parseInt(nk[0]);
            Solution sln = new Solution();
            ArrayList<ArrayList<Integer>> ans = sln.fourSum(a, k);
            for (ArrayList<Integer> v : ans) {
                for (int u : v) {
                    System.out.print(u + " ");
                }
                System.out.println();
            }
            if (ans.isEmpty()) {
                System.out.println(-1);
            }

            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

// arr[] : int input array of integers
// k : the quadruple sum required

class Solution {
   public ArrayList<ArrayList<Integer>> fourSum(int[] arr, int k) {
       
    Arrays.sort(arr); // Sort the array to apply the two-pointer approach
    Set<List<Integer>> set = new LinkedHashSet<>();
    int n = arr.length;

    // Fix the first element
    for(int i = 0; i < n - 3; i++) {
        // Fix the second element
        for(int j = i + 1; j < n - 2; j++) {
            int left = j + 1;
            int right = n - 1;

            // Two-pointer approach for the remaining two elements
            while (left < right) {
                long sum = (long) arr[i] + arr[j] + arr[left] + arr[right];

                if(sum == k) {
                    List<Integer> list = Arrays.asList(arr[i], arr[j], arr[left], arr[right]);
                    set.add(list); 
                    left++;
                    right--;

                    // skip duplicate val
                    while (left < right && arr[left] == arr[left - 1]) {left++;}
                    while (left < right && arr[right] == arr[right + 1]){right--;}
                } else if (sum < k) {
                    left++; 
                } else {
                    right--;
                }
            }
        }
    }

        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        for (List<Integer> quad : set) {
            result.add(new ArrayList<>(quad));
        }
        return result;
   }
}