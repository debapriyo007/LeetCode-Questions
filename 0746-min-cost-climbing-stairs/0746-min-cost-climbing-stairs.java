class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
	    int[] dp = new int[n];
        
	    for (int i=0; i<n; i++) {
		    if (i<2) dp[i] = cost[i];
		    else dp[i] = cost[i] + Math.min(dp[i-1], dp[i-2]);
	    }
	    return Math.min(dp[n-1], dp[n-2]);
        // int n = cost.length;
        // return Math.min(helper(cost, n-1, dp), helper(cost, n-2, dp));
    }
    
    //memeoization
    static int helper(int[] arr, int index, int[]dp){
        if(index <0)return 0;
        if(index == 0 || index ==1)return arr[index];
        if(dp[index]!= 0)return dp[index];
        return dp[index] =  arr[index] + Math.min(helper(arr, index-1, dp), helper(arr, index-2, dp));
        
    }
    
}