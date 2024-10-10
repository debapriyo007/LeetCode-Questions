class Solution {
    public int maxWidthRamp(int[] nums) {
        
        int maxDis = 0;
        int n = nums.length;
        //solve using Monotinic Stack. mantain decreasing order.
        Stack<Integer> stk = new Stack<>();
        for(int i = 0;i<n;i++){
            //store the index.
            if(stk.isEmpty() || nums[stk.peek()] > nums[i]){
                stk.push(i);
            }
        }
        
        for(int i = n-1;i>= 0;i--){
            while(!stk.isEmpty() && nums[stk.peek()] <= nums[i]){
                int currDis = i - stk.pop();
                maxDis = Math.max(maxDis, currDis);
            }
        }
      
        return maxDis;
        
        // for(int i = 0;i<nums.length;i++){
        //     for(int j = nums.length -1;j>0;j--){
        //         if(nums[j]>= nums[i]){
        //             int currDis = j-i;
        //             maxDis = Math.max(maxDis, currDis);
        //         }
        //     }
        // }
      
    }
}