class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        Stack<Integer>stk = new Stack<>();
        int[]nge = new int[n];
        
        //hypothetically thing that array is double(to find the ele in circular way.)
        // concept of circular array.
        for(int i = 2*n-1 ;i>= 0 ;i--){
            while(!stk.isEmpty() && stk.peek() <= nums[i%n]){
                stk.pop();
            }
            if(i<n){
                nge[i] = (stk.isEmpty())?-1:stk.peek();
            }
            stk.push(nums[i%n]);
        }
        return nge;
    }
}