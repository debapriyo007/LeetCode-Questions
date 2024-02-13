class Solution {
    public int longestConsecutive(int[] nums) {
        
         //Step 1: Add all numbers in a Set.
        HashSet<Integer> set = new HashSet<>();
        for( int i = 0;i<nums.length;i++){
            set.add(nums[i]);
        }
        
        int longestLen = 0;
        
        for(int i = 0;i<nums.length;i++){
            if(!set.contains(nums[i]-1)){
                int currNum = nums[i];
                int currLen = 1;
                while(set.contains(currNum+1)){
                    currNum +=1;
                    currLen+=1;
                }
                 longestLen = Math.max(longestLen,currLen);
            }
           
        }
        return longestLen;
    }
}