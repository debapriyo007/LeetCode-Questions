class Solution {
    public int longestSquareStreak(int[] nums) {
        int maxLen = 0;

        Set<Long> set = new HashSet<>();
        for (int x : nums) {
            set.add((long)x);
        }

        for (int xx : nums) {
            long ele = xx;
            int len = 1;

            while(set.contains(ele * ele)) {
                ele *= ele;
                len++;
            }

            maxLen = Math.max(maxLen, len);
        }

        return (maxLen > 1) ? maxLen : -1;
    }
}