class Solution {
    public int maximalRectangle(char[][] matrix) {
        
        HistogramQuestion h1 = new HistogramQuestion();
        int rows = matrix.length;
        int cols = matrix[0].length;
        
        int maxArea = 0;
        int[] heights = new int[cols];
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                // cal the prefix sum of heights
                if (matrix[i][j] == '1') {
                    heights[j] += 1;
                } else {
                    heights[j] = 0;
                }
            }
            // Apply largest rectangle in histogram for the current row height
            maxArea = Math.max(maxArea, h1.largestRectangleArea(heights));
        }
        return maxArea;
    }
    
}

class HistogramQuestion {
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
