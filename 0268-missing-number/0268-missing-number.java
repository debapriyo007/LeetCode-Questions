class Solution {
    public int missingNumber(int[] nums) {
        
        int n = nums.length;
        //fist cal the n'th sum of my array.
        int nthSum = n * (n+1)/2;
        
        //now i'm cal the actual sum.
        int sum = 0;
        for(int i : nums){
            sum+= i;
        }
        return nthSum - sum;
    }
}