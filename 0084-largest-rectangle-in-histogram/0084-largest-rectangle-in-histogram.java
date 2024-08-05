
class Solution {
    public int largestRectangleArea(int[] heights) {
        // approach is: if I'm standing on i'th bar then from that I will call the NSE and PSE
        // if I apply math, I will get the width (PSE - NSE - 1) and multiply with i'th bar height
        // and you will get the i'th bar area.
        
        HelperMethods help = new HelperMethods(); 
        
        int[] nse = help.nextSmallerEl(heights);
        int[] pse = help.prevSmallerEl(heights);
        
        int maxArea = 0; // Initialize maxArea to 0 instead of Integer.MIN_VALUE
        for (int i = 0; i < heights.length; i++) {
            maxArea = Math.max(maxArea, heights[i] * (nse[i] - pse[i] - 1)); 
        }
        return maxArea;
    }
    
    class HelperMethods {
        // Find the next smaller element.
        public int[] nextSmallerEl(int[] arr) {
            int n = arr.length;
            Stack<Integer> stk = new Stack<>();
            int[] nse = new int[n];
            
            for (int i = n - 1; i >= 0; i--) {
                while (!stk.isEmpty() && arr[stk.peek()] >= arr[i]) {
                    stk.pop();
                }
                nse[i] = (stk.isEmpty()) ? n : stk.peek();
                stk.push(i);
            }
            return nse;
        }
       
        // Find the previous smaller element.
        public int[] prevSmallerEl(int[] arr) {
            int n = arr.length;
            Stack<Integer> stk = new Stack<>();
            int[] pse = new int[n];
            
            for (int i = 0; i < n; i++) {
                while (!stk.isEmpty() && arr[stk.peek()] >= arr[i]) {
                    stk.pop();
                }
                pse[i] = (stk.isEmpty()) ? -1 : stk.peek();
                stk.push(i);
            }
            return pse;
        }
    }
}
