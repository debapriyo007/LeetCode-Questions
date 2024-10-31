class Solution {

    public long minimumTotalDistance(List<Integer> robot, int[][] factory) {
        Collections.sort(robot);
        Arrays.sort(factory, (a, b) -> a[0] - b[0]);

        Long[][] dp = new Long[robot.size() + 1][factory.length + 1];
        return solveMemo(robot, factory, 0, 0, dp);
    }
    
      long solveMemo(List<Integer> robot, int[][] factory, int idx1, int idx2, Long[][] dp) {
        // edge
        if(idx1 >= robot.size()){
            return 0L;
        }
        if(idx2 >= factory.length){
            return Long.MAX_VALUE;
        }

        // step-2: if already cal
        // just return it
        if(dp[idx1][idx2] != null){
            return dp[idx1][idx2];
        }

        // step-3: if not cal
        // just cal it
        long temp = 0;
        long res = solveMemo(robot, factory, idx1, idx2 + 1, dp);
        for (int k = idx1; k < robot.size() && k - idx1 + 1 <= factory[idx2][1]; k++) {
            temp += Math.abs(robot.get(k) - factory[idx2][0]);
            long sm = solveMemo(robot, factory, k + 1, idx2 + 1, dp);
            if (sm != Long.MAX_VALUE) {
                res = Math.min(res, temp + sm);
            }
        }
        return dp[idx1][idx2] = res;
    }
}