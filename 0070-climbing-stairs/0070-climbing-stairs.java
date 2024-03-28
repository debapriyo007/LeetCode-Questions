class Solution {
    public int climbStairs(int n) {
        
        //using brute froce approach.
        //This code give u TLE
        // if(n == 0)return 1;
        // if(n<0)return 0;
        // return climbStairs(n-1)+climbStairs(n-2);
        int[]dp = new int[n+1];
        return memoization(dp, n);
    }
    
    //using memoization.
    static int memoization(int[]dp, int n){
        if(n == 0)return 1;
        if(n <0)return 0;
        
        if(dp[n]!= 0){
            //means my dp array is full
            return dp[n];
        }
        dp[n] = memoization(dp, n-1)+memoization(dp, n-2);
        return dp[n];
    }
    
}