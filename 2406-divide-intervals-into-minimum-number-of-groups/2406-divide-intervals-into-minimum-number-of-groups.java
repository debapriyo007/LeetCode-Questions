class Solution {
    public int minGroups(int[][] intervals) {
        
        //In this question SLA(Sweep Line Alogo) algo is used.
        
        //find the range.
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int n = intervals.length;
        
        for(int i = 0;i<n;i++){
           min = Math.min(min, intervals[i][0]);
           max = Math.max(max, intervals[i][1]);
        }
        
        //here Sweep Line alog is started. There are two pointer "st", "end" go "st" index and doing +1 and go "end" index -1;
        int[]evntCnt = new int[max+2];
        for(int i = 0;i<n;i++){
            evntCnt[intervals[i][0]]++;
            evntCnt[intervals[i][1]+1]--;
        }
        
        //find the prefix sum of evntCnt array.
        for(int i = 1;i<evntCnt.length;i++){
            evntCnt[i] = evntCnt[i-1] + evntCnt[i];
        }
        
        //now find max which is my maximumOverLap.
        int ans = 0;
        for(int ele : evntCnt){
            ans = Math.max(ans, ele);
        }
        return ans;
    }
}