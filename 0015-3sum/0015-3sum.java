class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        
        //check edge cases.
        if(nums == null || nums.length<3)return new ArrayList<>();
        
        // Step 1: sort the array.
        Arrays.sort(nums);
        Set<List<Integer>> ans = new HashSet<>();
        
        
        //Step 2: Fixed the first element and find the other two elment.
        for(int i = 0;i<nums.length-2;i++){
            // 3rd step: take two pointer.
            int left = i+1;
            int right = nums.length-1;
            
            while(left<right){
                //calc the sum 
                int sum = nums[i] + nums[left] + nums[right];
                //if sum is equal to my target.
                if(sum == 0){
                    //add into my arrayList. move to find other triplets.
                    ans.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                    right--;
                }else if(sum<0){
                    left++;
                }else{
                    right--;
                }
            }
        }
        return new ArrayList<>(ans);
    }
}