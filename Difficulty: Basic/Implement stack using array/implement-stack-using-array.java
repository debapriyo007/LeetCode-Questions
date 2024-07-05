//{ Driver Code Starts
import java.util.*;

// Define MyStack class here

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        scanner.nextLine(); // Flush the newline character left by nextInt
        while (T-- > 0) {
            MyStack sq = new MyStack();
            String line = scanner.nextLine();
            Scanner ss = new Scanner(line);
            List<Integer> nums = new ArrayList<>();
            while (ss.hasNextInt()) {
                int num = ss.nextInt();
                nums.add(num);
            }
            int n = nums.size();
            int i = 0;
            while (i < n) {
                int QueryType = nums.get(i++);
                if (QueryType == 1) {
                    int a = nums.get(i++);
                    sq.push(a);
                } else if (QueryType == 2) {
                    System.out.print(sq.pop() + " ");
                }
            }
            System.out.println();
        }
        scanner.close();
    }
}

// } Driver Code Ends


class MyStack {
    private int[] arr;
    private int top;
    int index = 0;

    public MyStack() {
        arr = new int[1000];
        top = -1;
    }

    public void push(int x) {
        // Your Code
       
        arr[index] = x;
        index++;
    }

    public int pop() {
        // Your Code
        if(index == 0)return -1;
        int peek = arr[index-1];
        arr[index-1] = 0;
        index--;
        return peek;
    }
}
