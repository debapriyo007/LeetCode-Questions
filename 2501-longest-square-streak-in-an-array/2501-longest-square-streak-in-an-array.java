class Solution {
    public int longestSquareStreak(int[] nums) {
	   
        HashSet<Long> set = new HashSet<>();
        for (int x : nums) {
            set.add((long)x); 
        }
		
		// ArrayList<Integer> list = new ArrayList<>();
        int maxLen = 0;
	    for(int xx : nums){
            int len = 1;
            
            long currEle = xx;
            while(set.contains(currEle*currEle)){
                currEle = currEle*currEle;
                len++;
            }
            maxLen = Math.max(maxLen, len);
        }
        
        return (maxLen > 1) ? maxLen : -1; 
    }
}