class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int count = 0;
        int maxi = Integer.MIN_VALUE;
        
        for(int i = 0;i<nums.length;i++){
            if(nums[i]==1){
                count++;
            }else{
                count = 0;
            }
           maxi =  Math.max(count, maxi);
        }
        return maxi;
    }
}