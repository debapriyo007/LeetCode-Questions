class Solution {
    public int longestConsecutive(int[] nums) {
        
         //Step 1: Add all numbers in a Set.
        HashSet<Integer> set = new HashSet<>();
        for( int i = 0;i<nums.length;i++){
            set.add(nums[i]);
        }
        
        //declear my longest length.
        int longestLen = 0;
        
        //Step 2: Iterate through the array.
        for(int i = 0;i<nums.length;i++){
            // if my curr number -1 not present in the Set
            if(!set.contains(nums[i]-1)){
                //store my currNumber.
                int currNum = nums[i];
                //also store my curr number length.
                int currLen = 1;
                
                //My curr number next number is present in the Set 
                // like my curr num is - 99 , so , if 100 is present in the Set
                while(set.contains(currNum+1)){
                    
                    currNum +=1; //update 100 into 101 and so on.
                    currLen+=1; // also upadte the length as well
                }
                 longestLen = Math.max(longestLen,currLen); //compare with my currlen and my declear longest len.
            }
           
        }
        return longestLen;
    }
}